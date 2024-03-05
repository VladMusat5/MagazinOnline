package repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import repository.entity.base.BaseEntity;

import java.util.List;

@Entity(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends BaseEntity {
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
    private List<Order> orders;
}
