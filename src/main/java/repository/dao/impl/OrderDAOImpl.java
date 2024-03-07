package repository.dao.impl;

    import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
    import repository.dao.OrderDataAccessObject;
    import repository.entity.OrderEntity;
import java.util.List;
    public class OrderDAOImpl implements OrderDataAccessObject {
        private final SessionFactory sessionFactory;
        public OrderDAOImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
        @Override
        public OrderEntity save(OrderEntity order) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(order);
                transaction.commit();
            }
            return order;
        }
        @Override
        public void deleteById(OrderEntity order) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(order);
                transaction.commit();
            }
        }
        @Override
        public OrderEntity findById(Long id) {
            try (Session session = sessionFactory.openSession()) {
                return session.get(OrderEntity.class, id);
            }
        }
        @Override
        public List<OrderEntity> findAll() {
            try (Session session = sessionFactory.openSession()) {
                return session.createQuery("from Order", OrderEntity.class).list();
            }
        }
    }











