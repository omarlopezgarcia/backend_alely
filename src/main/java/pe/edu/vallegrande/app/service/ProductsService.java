package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.dto.ProductsDto;
import pe.edu.vallegrande.app.model.entity.Products;

import java.util.List;

public interface ProductsService {

    List<Products> getActive();
    List<Products> getInactive();
    Products getForId(Long id);
    ProductsDto created(ProductsDto productsDto);
    ProductsDto update(Long id, ProductsDto productsDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);

}
