package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.entity.Supplier;
import pe.edu.vallegrande.app.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers/active")
    public List<Supplier> getActive(){
        return supplierService.getActive();
    }

    @GetMapping("/suppliers/inactive")
    public List<Supplier> getInactive(){
        return supplierService.getInactive();
    }

    @GetMapping("/supplier/{id}")
    public Supplier getForId(@PathVariable Long id){
        return supplierService.getForId(id);
    }

    @PostMapping("/supplier/")
    public Supplier created(@RequestBody Supplier supplier){
        return supplierService.created(supplier);
    }

    @PutMapping("/supplier/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier){
        return supplierService.update(id, supplier);
    }

    @DeleteMapping("/supplier/removed/{id}")
    public void removed(@PathVariable Long id){
        supplierService.removed(id);
    }

    @DeleteMapping("/supplier/restore/{id}")
    public void restore(@PathVariable Long id){
        supplierService.restore(id);
    }

    @DeleteMapping("/supplier/{id}")
    public void delete(@PathVariable Long id){
        supplierService.delete(id);
    }

}
