/*
package repository.dao.impl;

    import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.entity.Order;
import java.util.List;
    public class OrderDAOImpl implements OrderDAO {
        private final SessionFactory sessionFactory;
        public OrderDAOImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
        @Override
        public void save(Order order) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(order);
                transaction.commit();
            }
        }
        @Override
        public void delete(Order order) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(order);
                transaction.commit();
            }
        }
        @Override
        public Order findById(Long id) {
            try (Session session = sessionFactory.openSession()) {
                return session.get(Order.class, id);
            }
        }
        @Override
        public List<Order> findAll() {
            try (Session session = sessionFactory.openSession()) {
                return session.createQuery("from Order", Order.class).list();
            }
        }
    }










}
*/
