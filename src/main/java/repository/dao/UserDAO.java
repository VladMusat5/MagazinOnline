package repository.dao;

import repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    UserEntity save(UserEntity user);

    void update(UserEntity user);

    void delete(UserEntity user);

    UserEntity findById(Long id);

    List<UserEntity> findAll();
}


