package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.entity.CategoryType;

import java.util.List;

public interface CategoryTypeService {

    List<CategoryType> getAll();
    CategoryType getForId(Long id);
    CategoryType created(CategoryType categoryType);
    CategoryType update(Long id, CategoryType categoryType);
    void delete(Long id);

}
