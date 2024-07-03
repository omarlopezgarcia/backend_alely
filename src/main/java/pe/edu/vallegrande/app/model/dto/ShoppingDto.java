package pe.edu.vallegrande.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ShoppingDto {

    private Long id;
    private Long humanResources;
    private Date dateOrder;
    private Date payDay;
    private Long supplier;
    private List<PurchaseDetailDto> purchaseDetail;

}
