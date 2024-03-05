package service.base;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.entity.OrderEntity;
import repository.entity.ProductEntity;
import repository.entity.UserEntity;

public abstract class BaseService {

    protected final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(OrderEntity.class)
            .addAnnotatedClass(ProductEntity.class)
            .addAnnotatedClass(UserEntity.class)
            .buildSessionFactory();
}
