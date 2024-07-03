package pe.edu.vallegrande.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "human_resources")
@Data @NoArgsConstructor @AllArgsConstructor
public class HumanResources {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "document_type")
        private String documentType;

        @Column(name = "document_number")
        private String documentNumber;

        @Column(name = "cellphone")
        private String cellphone;

        @ManyToOne
        @JoinColumn(name = "area_id", nullable = false)
        private Area area;

        @Column(name = "status")
        private String status = "A";
    }
