package repository.dao;

import repository.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    void save(ProductEntity product);

    void delete(ProductEntity product);

    ProductEntity findById(Long id);

    List<ProductEntity> findAll();
}

