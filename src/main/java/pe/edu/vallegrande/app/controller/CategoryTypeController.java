package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.entity.CategoryType;
import pe.edu.vallegrande.app.service.CategoryTypeService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class CategoryTypeController {

    @Autowired
    private CategoryTypeService categoryTypeService;

    @GetMapping("/categories")
    public List<CategoryType> getAll(){
        return categoryTypeService.getAll();
    }

    @GetMapping("/category")
    public CategoryType getForId(@PathVariable Long id){
        return categoryTypeService.getForId(id);
    }

    @PostMapping("/category/")
    public CategoryType created(@RequestBody CategoryType categoryType){
        return categoryTypeService.created(categoryType);
    }

    @PutMapping("/category/{id}")
    public CategoryType update(@PathVariable Long id, @RequestBody CategoryType categoryType){
        return categoryTypeService.update(id, categoryType);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Long id){
        categoryTypeService.delete(id);
    }

}
