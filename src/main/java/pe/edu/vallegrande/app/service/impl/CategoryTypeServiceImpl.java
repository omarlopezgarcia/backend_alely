package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.app.model.entity.CategoryType;
import pe.edu.vallegrande.app.repository.CategoryTypeRepository;
import pe.edu.vallegrande.app.service.CategoryTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryTypeServiceImpl implements CategoryTypeService  {

    @Autowired
    private CategoryTypeRepository categoryTypeRepository;

    @Override
    public List<CategoryType> getAll() {
        return categoryTypeRepository.findAll();
    }

    @Override
    public CategoryType getForId(Long id) {
        return categoryTypeRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryType created(CategoryType categoryType) {
        return categoryTypeRepository.save(categoryType);
    }

    @Override
    public CategoryType update(Long id, CategoryType categoryTypes) {
        Optional<CategoryType> categoryTypeId = categoryTypeRepository.findById(id);
        if (categoryTypeId.isPresent()){
            CategoryType categoryType = categoryTypeId.get();
            categoryType.setName(categoryTypes.getName());
            return categoryTypeRepository.save(categoryType);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        categoryTypeRepository.deleteById(id);
    }

}
