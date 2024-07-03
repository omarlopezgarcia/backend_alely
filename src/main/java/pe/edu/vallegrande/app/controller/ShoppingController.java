package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.dto.ShoppingDto;
import pe.edu.vallegrande.app.model.entity.PurchaseDetail;
import pe.edu.vallegrande.app.model.entity.Shopping;
import pe.edu.vallegrande.app.service.ShoppingService;
import pe.edu.vallegrande.app.service.PurchaseDetailService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @GetMapping("/shoppings/active")
    public List<Shopping> getActive(){
        return shoppingService.getActive();
    }

    @GetMapping("/shoppings/inactive")
    public List<Shopping> getInactive(){
        return shoppingService.getInactive();
    }

    @GetMapping("/shopping/{id}")
    public Shopping getForId(@PathVariable Long id){
        return shoppingService.getForId(id);
    }

    @GetMapping("/purchaseDetail/all")
    public List<PurchaseDetail> getAll(){
        return purchaseDetailService.getAll();
    }

    @GetMapping("/purchaseDetail/{id}")
    public List<PurchaseDetail> getForIdShopping(@PathVariable Long id){
        return purchaseDetailService.getForIdShopping(id);
    }

    @PostMapping("/shopping/")
    public ShoppingDto created(@RequestBody ShoppingDto shoppingDto){
        return shoppingService.created(shoppingDto);
    }

    @PutMapping("/shopping/{id}")
    public ShoppingDto update(@PathVariable Long id, @RequestBody ShoppingDto shoppingDto){
        return shoppingService.update(id, shoppingDto);
    }

    @DeleteMapping("/shopping/removed/{id}")
    public void removed(@PathVariable Long id){
        shoppingService.removed(id);
    }

    @DeleteMapping("/shopping/restore/{id}")
    public void restore(@PathVariable Long id){
        shoppingService.restore(id);
    }

    @DeleteMapping("/shopping/{id}")
    public void delete(@PathVariable Long id){
        shoppingService.delete(id);
    }

    @DeleteMapping("/purchaseDetail/{id}")
    public void deleteDetail(@PathVariable Long id){
        purchaseDetailService.delete(id);
    }

}
