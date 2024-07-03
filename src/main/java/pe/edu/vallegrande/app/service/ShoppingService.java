package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.dto.ShoppingDto;
import pe.edu.vallegrande.app.model.entity.Shopping;

import java.util.List;

public interface ShoppingService {

    List<Shopping> getActive();
    List<Shopping> getInactive();
    Shopping getForId(Long id);
    ShoppingDto created(ShoppingDto shoppingDto);
    ShoppingDto update(Long id, ShoppingDto shoppingDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);

}
