package pe.edu.vallegrande.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Shopping {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "human_resources_id", nullable = false)
        private HumanResources humanResources;

        @Column(name = "date_order")
        private Date dateOrder;

        @Column(name = "pay_day")
        private Date payDay;

        @ManyToOne
        @JoinColumn(name = "supplier_id", nullable = false)
        private Supplier supplier;

        @Column(name = "status")
        private String status = "A";

}
