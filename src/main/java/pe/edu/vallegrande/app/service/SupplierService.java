package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> getActive();
    List<Supplier> getInactive();
    Supplier getForId(Long id);
    Supplier created(Supplier supplier);
    Supplier update(Long id, Supplier supplier);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);

}
