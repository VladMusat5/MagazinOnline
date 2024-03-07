package repository.dao;

import repository.entity.OrderEntity;

import java.util.List;

public interface OrderDataAccessObject {
    //Clasele care reprezinta "comunicarea" dintre aplicatia noastra si baza de date
    OrderEntity save (OrderEntity order);

    void deleteById(OrderEntity order);

    OrderEntity findById(Long id);

    List<OrderEntity> findAll();
}
