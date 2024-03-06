package repository.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.dao.UserDAO;
import repository.entity.UserEntity;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity save(UserEntity user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void update(UserEntity user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void delete(UserEntity user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public UserEntity findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(UserEntity.class, id);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", UserEntity.class).list();
        }
    }
}