package repository.dao.impl;

import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.dao.UserDAO;
import repository.entity.ProductEntity;
import repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

// cel de jos este pe jumatate terminat
//    @Override
//    public UserEntity findById(Integer id) {
//        EntityTransaction transaction = null;
//        Optional<ProductEntity> found = Optional.empty();
//        try  {
//            transaction = entityManager
//
//        }
//    }

    @Override
    public List<UserEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", UserEntity.class).list();
        }
    }
}