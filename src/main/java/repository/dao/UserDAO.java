package repository.dao;

import repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    UserEntity save (UserEntity user);

    void deleteById (Integer id);

    Optional<UserEntity> findById (Integer id);

    List<UserEntity> findAll();
}
