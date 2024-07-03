package pe.edu.vallegrande.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductsDto {
    private Long id;
    private String serie;
    private String name;
    private String amount;
    private Double cost;
    private String brand;
    private Date admissionDate;
    private Long categoryType;

}
