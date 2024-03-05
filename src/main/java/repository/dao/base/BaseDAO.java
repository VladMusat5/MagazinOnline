package repository.dao.base;

import jakarta.persistence.EntityManager;

public class BaseDAO {
    protected final EntityManager entityManager;


    protected  BaseDAO (EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
