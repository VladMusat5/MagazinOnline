package repository.dao;

import repository.entity.OrderEntity;
import repository.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    OrderEntity save (OrderEntity order);

    void deleteById (Integer id);

    Optional<OrderEntity> findById (Integer id);

    List<OrderEntity> findAll();
}
