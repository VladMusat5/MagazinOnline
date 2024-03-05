package repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import repository.entity.base.BaseEntity;

import java.util.List;

@Entity(name = "products")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode (callSuper = true)
public class Product extends BaseEntity {

    @Column (name = "product_name")
    @NonNull
    private String productName;

    @Column (name = "order_id")
    @NonNull
    private Integer orderId;

    @ManyToOne
    @JoinColumn (name = "id")
    private List<Order> orders;
}
