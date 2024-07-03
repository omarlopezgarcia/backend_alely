package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.dto.ProductsDto;
import pe.edu.vallegrande.app.model.entity.Products;
import pe.edu.vallegrande.app.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products/active")
    public List<Products> getActive(){
        return productsService.getActive();
    }

    @GetMapping("/products/inactive")
    public List<Products> getInactive(){
        return productsService.getInactive();
    }

    @GetMapping("/product/{id}")
    public Products getForId(@PathVariable Long id){
        return productsService.getForId(id);
    }

    @PostMapping("/product/")
    public ProductsDto created(@RequestBody ProductsDto productsDto){
        return productsService.created(productsDto);
    }

    @PutMapping("/product/{id}")
    public ProductsDto update(@PathVariable Long id, @RequestBody ProductsDto productsDto){
        return productsService.update(id, productsDto);
    }

    @DeleteMapping("/product/removed/{id}")
    public void removed(@PathVariable Long id){
        productsService.removed(id);
    }

    @DeleteMapping("/product/restore/{id}")
    public void restore(@PathVariable Long id){
        productsService.restore(id);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        productsService.delete(id);
    }

}
