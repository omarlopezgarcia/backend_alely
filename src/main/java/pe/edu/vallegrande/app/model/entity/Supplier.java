package pe.edu.vallegrande.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier")
@Data @NoArgsConstructor @AllArgsConstructor
public class Supplier {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "cellphone")
        private String cellphone;

        @Column(name = "email")
        private String email;

        @Column(name = "status")
        private String status = "A";
}
