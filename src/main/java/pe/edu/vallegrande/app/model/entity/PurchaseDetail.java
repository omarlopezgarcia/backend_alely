package pe.edu.vallegrande.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_detail")
@Data @AllArgsConstructor @NoArgsConstructor
public class PurchaseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shopping_id")
    private Shopping shopping;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;

}
