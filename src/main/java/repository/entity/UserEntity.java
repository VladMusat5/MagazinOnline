package repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@Data

public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "address")
    @NonNull
    private String address;

    @OneToMany (mappedBy = "user")
    private List<OrderEntity> orderEntity;

    public UserEntity(String Name, String LastName, String Adress) {
        this.address = Adress;
        this.lastName = LastName;
        this.name = Name;
    }
}
