package com.team6.beertagweb.repositories;

import com.team6.beertagweb.exception.DatabaseItemNotFoundException;
import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.repositories.base.BeerRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BeerRepositorySql implements BeerRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public BeerRepositorySql(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Beer> getAllBeersSortedByRating(Beer beer) {

        List<Beer> beersSortedByRating;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            beersSortedByRating = session
                    .createQuery(
                            "FROM Rating r " +
                                    "WHERE r.user in " +
                                    "(SELECT beer.id from Beer beer where beer.id=:beer_id_ratings)" +
                                    "ORDER BY r.rating desc ", Beer.class)

                    .setParameter("beer_id_ratings", beer.getId())
                    .list();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return beersSortedByRating;
    }


    @Override
    public List<Beer> getAllBeers() {
        List<Beer> beers;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            beers = session.createQuery("from Beer", Beer.class).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return beers;
    }

    @Override
    public Beer getBeerById(int id) {
        Beer beer;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            beer = session.get(Beer.class, id);
            transaction.commit();

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            throw he;
        }

        if (beer == null) {
            throw new DatabaseItemNotFoundException(id);
        }
        return beer;
    }


    @Override
    public List<Beer> getBeersByCountry(int id) {
        List<Beer> beersByCountry = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session
                    .createSQLQuery("SELECT b.beer_id from beer b where b.beer_origin_country_id =:countryId");
            query.setParameter("countryId", id);

            System.out.println(query.list().size());

            for (Object obj : query.list()) {
                Beer beer = getBeerById((int) obj);
                beersByCountry.add(beer);
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return beersByCountry;
    }

    @Override
    public List<Beer> getBeersByTag(int tagId) {
        List<Beer> beersByTag = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query qyuer = session
                    .createSQLQuery("SELECT b.beer_id from beer_tags_relationship b where b.tag_id =:tagId");
            qyuer.setParameter("tagId", tagId);

            System.out.println(qyuer.list().size());

            for (Object o : qyuer.list()) {
                beersByTag.add(getBeerById((int) o));
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return beersByTag;
    }

    @Override
    public List<Beer> getBeersByStyle(int beerStyle) {
        List<Beer> beersByStyle;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            beersByStyle = session
                    .createQuery("from Beer b " +
                            " where b.style.id=:beerStyle", Beer.class)
                    .setParameter("beerStyle", beerStyle)
                    .list();


            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return beersByStyle;
    }

    @Override
    public void createBeer(Beer beerToCreate) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(beerToCreate);
            transaction.commit();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            throw he;
        }
    }

    @Override
    public void deleteBeer(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Beer beerToDelete = session.get(Beer.class, id);
            session.delete(beerToDelete);
            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }

    @Override
    public Beer editBeer(Beer beerToEdit) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.update(beerToEdit);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return beerToEdit;
    }


    @Override
    public List<Beer> getAllBeersSortedByAbv() {
        List<Beer> beersSortedByAbv;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            beersSortedByAbv = session
                    .createQuery("FROM Beer  ORDER BY abv DESC", Beer.class)
                    .list();
            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }

        return beersSortedByAbv;
    }

    @Override
    public Beer beerAddTag(int beerId, Tag tag) {
        Beer beer = getBeerById(beerId);
        int tagId = tag.getId();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createSQLQuery("insert into beer_tags_relationship (beer_id, tag_id) values (:beer_id,:tag_id)");
            query.setParameter("beer_id", beerId);
            query.setParameter("tag_id", tagId);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return beer;
    }

    @Override
    public List<Beer> getAllBeersSortedByName() {
        List<Beer> beersSortedByName;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            beersSortedByName = session
                    .createQuery("FROM  Beer ORDER BY beerName", Beer.class)
                    .list();

            transaction.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        }
        return beersSortedByName;
    }

}
