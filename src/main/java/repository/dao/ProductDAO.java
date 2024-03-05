package repository.dao;

import repository.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    ProductEntity save (ProductEntity product);

    void deleteById (Integer id);

    Optional<ProductEntity> findById (Integer id);

    List<ProductEntity> findAll();
}
