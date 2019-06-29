package com.team6.beertagweb.repositories;

import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.repositories.base.TagRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
@Repository
public class TagRepositorySql implements TagRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TagRepositorySql(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Tag getTagById(int id) {
        Tag tag;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            tag = session.get(Tag.class, id);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return tag;
    }

    @Override
    public List<Tag> getAllTags() {
        List<Tag> allTags;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Tag> criteriaQuery = criteriaBuilder.createQuery(Tag.class);
            criteriaQuery.from(Tag.class);

            allTags = session
                    .createQuery(criteriaQuery)
                    .getResultList();

            transaction.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }

        return allTags;
    }

    @Override
    public Tag addNewTag(Tag newTag) {
        Integer id;
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            List list;
            Query query = session.createSQLQuery(String.format("Select * from tag where tag_content like '%s'", newTag.getTagTitle()));

            list = query.getResultList();

            if (list.size() == 0) {
                return newTag;
            }

            id = (Integer) session.save(newTag);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return getTagById(id);
    }

    @Override
    public void deleteTag(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tagToDelete = session.get(Tag.class, id);
            session.delete(tagToDelete);
            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }
}
