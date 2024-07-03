package pe.edu.vallegrande.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor
public class Products {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "serie")
        private String serie;

        @Column(name = "name")
        private String name;

        @Column(name = "amount")
        private String amount;

        @Column(name = "cost")
        private Double cost;

        @Column(name = "brand")
        private String brand;

        @Column(name = "admission_date")
        private Date admissionDate;

        @ManyToOne
        @JoinColumn(name = "category_type_id", nullable = false)
        private CategoryType categoryType;

        @Column(name = "status")
        private String status = "A";

    }
