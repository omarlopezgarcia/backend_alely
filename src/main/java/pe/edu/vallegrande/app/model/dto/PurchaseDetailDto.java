package pe.edu.vallegrande.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PurchaseDetailDto {

    private Long id;
    private int amount;
    private Long shopping;
    private String products;

}
