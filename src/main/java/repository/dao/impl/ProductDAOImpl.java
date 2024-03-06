package repository.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.dao.ProductDAO;
import repository.entity.ProductEntity;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
        private final SessionFactory sessionFactory;

        public ProductDAOImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        public void save(ProductEntity product) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(product);
                transaction.commit();
            }
        }

        @Override
        public void delete(ProductEntity product) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(product);
                transaction.commit();
            }
        }

        @Override
        public ProductEntity findById(Long id) {
            try (Session session = sessionFactory.openSession()) {
                return session.get(ProductEntity.class, id);
            }
        }

        @Override
        public List<ProductEntity> findAll() {
            try (Session session = sessionFactory.openSession()) {
                return session.createQuery("from Product", ProductEntity.class).list();
            }
        }
    }
