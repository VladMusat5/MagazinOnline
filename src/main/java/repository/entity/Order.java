package repository.entity;

import jakarta.persistence.*;
import lombok.*;
import repository.entity.base.BaseEntity;

import java.util.List;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString // intraba daca punem exclude si ce am exclude
public class Order extends BaseEntity {
    @Column(name = "order_number")
    @NonNull
    private Integer orderNumber;

    @Column(name = "product_id")
    @NonNull
    private Integer productId;

    @ManyToOne
    @JoinColumn (name = "id")
    private User user;

    @OneToMany (mappedBy = "product")
    private List<Product> products;
}
