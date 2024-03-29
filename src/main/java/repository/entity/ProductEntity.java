package repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Data

public class ProductEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    @NonNull
    private String productName;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
