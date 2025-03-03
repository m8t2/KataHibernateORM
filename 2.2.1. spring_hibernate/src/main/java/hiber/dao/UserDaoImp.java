package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u ");
        return query.getResultList();
    }

    @Override
    public User findUserByCar(String model, Long series) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select u from User u join fetch u.car c where c.model = :model and c.series = :series"
        );
        query.setParameter("series", series);
        query.setParameter("model", model);

        return (User) query.getSingleResult();
    }

}
