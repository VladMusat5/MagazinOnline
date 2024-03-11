package repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Data

public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List<OrderEntity> orderEntity = new ArrayList<>();

    public UserEntity(String Name, String LastName, String Adress) {
        this.name = Name;
        this.lastName = LastName;
        this.address = Adress;
    }
}
