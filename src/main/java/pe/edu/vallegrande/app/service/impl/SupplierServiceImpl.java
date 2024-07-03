package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.app.model.entity.Supplier;
import pe.edu.vallegrande.app.repository.SupplierRepository;
import pe.edu.vallegrande.app.service.SupplierService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getActive() {
        return supplierRepository.findByActiveSupplier("A");
    }

    @Override
    public List<Supplier> getInactive() {
        return supplierRepository.findByActiveSupplier("I");
    }

    @Override
    public Supplier getForId(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier created(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Long id, Supplier suppliers) {
        Optional<Supplier> supplierId = supplierRepository.findById(id);
        if(supplierId.isPresent()){
            Supplier supplier = supplierId.get();
            supplier.setName(suppliers.getName());
            supplier.setCellphone(suppliers.getCellphone());
            supplier.setEmail(suppliers.getEmail());
            return supplierRepository.save(supplier);
        } else {
            return null;
        }
    }

    @Override
    public void removed(Long id) {
        supplierRepository.removeById(id);
    }

    @Override
    public void restore(Long id) {
        supplierRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

}
