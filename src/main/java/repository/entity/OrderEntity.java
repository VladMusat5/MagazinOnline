package repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString

public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_number")
    @NonNull
    private Integer orderNumber;

    @Column(name = "product_id")
    @NonNull
    private Integer productId;

    @JoinColumn(name = "user")
    private UserEntity user;

    @OneToMany (mappedBy = "order")
    private List<ProductEntity> productEntities;
}
