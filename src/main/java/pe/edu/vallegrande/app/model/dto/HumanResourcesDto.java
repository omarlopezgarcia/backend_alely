package pe.edu.vallegrande.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class HumanResourcesDto {

    private Long id;
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String cellphone;
    private Long area;

}
