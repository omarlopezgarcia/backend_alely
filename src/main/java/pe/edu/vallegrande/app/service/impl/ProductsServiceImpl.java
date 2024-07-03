package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.dto.ProductsDto;
import pe.edu.vallegrande.app.model.entity.CategoryType;
import pe.edu.vallegrande.app.model.entity.Products;
import pe.edu.vallegrande.app.repository.CategoryTypeRepository;
import pe.edu.vallegrande.app.repository.ProductsRepository;
import pe.edu.vallegrande.app.service.ProductsService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryTypeRepository categoryTypeRepository;

    @Override
    public List<Products> getActive() {
        return productsRepository.findByActiveProduct("A");
    }

    @Override
    public List<Products> getInactive() {
        return productsRepository.findByActiveProduct("I");
    }

    @Override
    public Products getForId(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public ProductsDto created(ProductsDto productsDto) {
        CategoryType categoryType = categoryTypeRepository.findById(productsDto.getCategoryType()).orElseThrow(() -> new RuntimeException("CategoryType not found"));
        Products products = new Products();
        products.setSerie(productsDto.getSerie());
        products.setName(productsDto.getName());
        products.setAmount(productsDto.getAmount());
        products.setCost(productsDto.getCost());
        products.setBrand(productsDto.getBrand());
        products.setAdmissionDate(productsDto.getAdmissionDate());
        products.setCategoryType(categoryType);
        products = productsRepository.save(products);
        productsDto.setId(products.getId());
        return productsDto;
    }

    @Transactional
    @Override
    public ProductsDto update(Long id, ProductsDto productsDto) {
        Optional<Products> productsOptional = productsRepository.findById(id);
        if (productsOptional.isPresent()) {
            CategoryType categoryType = categoryTypeRepository.findById(productsDto.getCategoryType()).orElseThrow(() -> new RuntimeException("CategoryType not found"));
            Products products = productsOptional.get();
            products.setSerie(productsDto.getSerie());
            products.setName(productsDto.getName());
            products.setAmount(productsDto.getAmount());
            products.setCost(productsDto.getCost());
            products.setBrand(productsDto.getBrand());
            products.setAdmissionDate(productsDto.getAdmissionDate());
            products.setCategoryType(categoryType);
            products = productsRepository.save(products);
            productsDto.setId(products.getId());
            return productsDto;
        } else {
            throw null;
        }
    }

    @Override
    public void removed(Long id) {
        productsRepository.removeById(id);
    }

    @Override
    public void restore(Long id) {
        productsRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

}
