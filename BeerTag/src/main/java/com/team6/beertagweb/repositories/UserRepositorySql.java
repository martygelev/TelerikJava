package com.team6.beertagweb.repositories;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositorySql implements UserRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositorySql(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rating rateBeer(int userId, int beerId, int ratingToAdd) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = getUserById(userId);
            Beer beer = session.get(Beer.class, beerId);

            Rating beerRating;

            Query<Rating> query = session.createQuery("from Rating r where r.beer.id = :beerID and r.user.id = :userID");
            query.setParameter("beerID", beerId);
            query.setParameter("userID", userId);

            try {
                beerRating = query.getSingleResult();

            } catch (NoResultException ex) {
                beerRating = new Rating();
                beerRating.setBeer(beer);
                beerRating.setUser(user);
            }

            beerRating.setRating(ratingToAdd);

            session.getTransaction().commit();
            return beerRating;
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            throw he;
        }
    }


    @Override
    public User getUserById(int userId) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, userId);
            transaction.commit();
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw e;
        }
        return user;
    }

    @Override
    public void updateUser(User userToUpdate, int userId) {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            session.update(User.class);

            transaction.commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getUsers() {

        List<User> users;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            users = session
                    .createQuery("From User ", User.class)
                    .list();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return users;
    }

    @Override
    public void addBeerToDrank(int userId, int beerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createSQLQuery("insert into beer_user_status_relationship (user_id, beer_id, beer_id_status) values (:user,:beer,:status)");
            query.setParameter("user", userId);
            query.setParameter("beer", beerId);
            query.setParameter("status", 1);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public void addBeerToWantToDrink(int userId, int beerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createSQLQuery("insert into beer_user_status_relationship (user_id, beer_id, beer_id_status) values (:user,:beer,:status)");
            query.setParameter("user", userId);
            query.setParameter("beer", beerId);
            query.setParameter("status", 2);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public List<Beer> getDrank(int userId) {
        List<Beer> beerList = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List list;

            Query query = session.createSQLQuery(String.format("Select b.beer_id from user u" +
                    "                 join beer_user_status_relationship st on u.user_id = st.user_id" +
                    "                  join beer b on b.beer_id = st.beer_id" +
                    "              join status s on s.status_id = st.beer_id_status" +
                    "             where u.user_id = %d" +
                    "           and  s.status_type in" +
                    "           (select ss.status_type from Status ss where ss.status_id =1 )", userId));

            list = query.getResultList();
            transaction.commit();

            for (Object o : list) {
                Beer beer = session.get(Beer.class, (int) o);
                beerList.add(beer);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return beerList;
    }

    @Override
    public List<Beer> getWantToDrink(int userId) {
        List<Beer> beerList = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List list;

            Query query = session.createSQLQuery(String.format("Select b.beer_id from user u" +
                    "                 join beer_user_status_relationship st on u.user_id = st.user_id" +
                    "                  join beer b on b.beer_id = st.beer_id" +
                    "              join status s on s.status_id = st.beer_id_status" +
                    "             where u.user_id = %d" +
                    "           and  s.status_type in" +
                    "           (select ss.status_type from Status ss where ss.status_id =2 )", userId));

            list = query.getResultList();
            transaction.commit();

            for (Object o : list) {

                Beer beer = session.get(Beer.class, (int) o);
                beerList.add(beer);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return beerList;
    }

    @Override
    public void removeFromWantToDrink(int userId, int beerId) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "delete from BeerUserStatus where user.id= :userId AND beer.id= :beerId and status.id=2";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("beerId", beerId);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void removeFromDrank(int userId, int beerId) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("delete from BeerUserStatus where user.id= :userId AND beer.id= :beerId and status.id=1");

            query.setParameter("userId", userId);
            query.setParameter("beerId", beerId);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


    @Override
    public User createUser(User userToCreate) {
        Integer id = 0;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            id = (Integer) session.save(userToCreate);
            transaction.commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return getUserById(id);
    }

}
