package repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class ProductEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    @NonNull
    private String productName;



    @ManyToOne
    @JoinColumn(name = "id")
    private OrderEntity order;
}
