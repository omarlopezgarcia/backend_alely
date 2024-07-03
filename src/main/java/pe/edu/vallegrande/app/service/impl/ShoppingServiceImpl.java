package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.dto.PurchaseDetailDto;
import pe.edu.vallegrande.app.model.dto.ShoppingDto;
import pe.edu.vallegrande.app.model.entity.*;
import pe.edu.vallegrande.app.repository.*;
import pe.edu.vallegrande.app.service.ShoppingService;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Autowired
    private HumanResourcesRepository humanResourcesRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Shopping> getActive() {
        return shoppingRepository.findByActiveShopping("A");
    }

    @Override
    public List<Shopping> getInactive() {
        return shoppingRepository.findByActiveShopping("I");
    }

    @Override
    public Shopping getForId(Long id) {
        return shoppingRepository.findById(id).orElse(null);
    }

    @Override
    public ShoppingDto created(ShoppingDto shoppingDto) {
        HumanResources humanResources = humanResourcesRepository.findById(shoppingDto.getHumanResources()).get();
        Supplier supplier = supplierRepository.findById(shoppingDto.getSupplier()).get();
        Shopping shopping = new Shopping();
        shopping.setDateOrder(shoppingDto.getDateOrder());
        shopping.setPayDay(shoppingDto.getPayDay());
        shopping.setHumanResources(humanResources);
        shopping.setSupplier(supplier);
        shopping = shoppingRepository.save(shopping);
        shoppingDto.setId(shopping.getId());
        for (PurchaseDetailDto pd: shoppingDto.getPurchaseDetail()){
            Products products = productsRepository.findById(Long.valueOf(pd.getProducts())).get();
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            purchaseDetail.setAmount(pd.getAmount());
            purchaseDetail.setProducts(products);
            purchaseDetail.setShopping(shopping);
            purchaseDetail = purchaseDetailRepository.save(purchaseDetail);
            pd.setId(purchaseDetail.getId());
        }
        return shoppingDto;
    }

    @Override
    public ShoppingDto update(Long id, ShoppingDto shoppingDto) {
        Optional<Shopping> optionalShopping = shoppingRepository.findById(id);
        if (optionalShopping.isPresent()) {
            Shopping shopping = optionalShopping.get();
            HumanResources humanResources = humanResourcesRepository.findById(shoppingDto.getHumanResources()).orElse(null);
            Supplier supplier = supplierRepository.findById(shoppingDto.getSupplier()).orElse(null);

            if (humanResources != null && supplier != null) {
                shopping.setDateOrder(shoppingDto.getDateOrder());
                shopping.setPayDay(shoppingDto.getPayDay());
                shopping.setHumanResources(humanResources);
                shopping.setSupplier(supplier);
                shopping = shoppingRepository.save(shopping);
                shoppingDto.setId(shopping.getId());

                // Obtén los detalles de préstamo existentes
                List<PurchaseDetail> existingPurchaseDetails = purchaseDetailRepository.findByShoppingId(shopping.getId());

                // Itera sobre los detalles proporcionados en el DTO
                for (PurchaseDetailDto pd : shoppingDto.getPurchaseDetail()) {
                    Products products = productsRepository.findById(Long.valueOf(pd.getProducts())).orElse(null);
                    if (products != null) {
                        // Verifica si el detalle de préstamo ya existe
                        Optional<PurchaseDetail> optionalExistingDetail = existingPurchaseDetails
                                .stream()
                                .filter(detail -> detail.getId().equals(pd.getId()))
                                .findFirst();

                        if (optionalExistingDetail.isPresent()) {
                            // Si existe, actualiza los campos
                            PurchaseDetail existingDetail = optionalExistingDetail.get();
                            existingDetail.setAmount(pd.getAmount());
                            existingDetail.setProducts(products);
                            purchaseDetailRepository.save(existingDetail);
                        } else {
                            // Si no existe, crea uno nuevo
                            PurchaseDetail newDetail = new PurchaseDetail();
                            newDetail.setAmount(pd.getAmount());
                            newDetail.setProducts(products);
                            newDetail.setShopping(shopping);
                            purchaseDetailRepository.save(newDetail);
                        }
                    }
                }

                // Elimina los detalles que ya no están en el DTO
                existingPurchaseDetails
                        .stream()
                        .filter(detail -> !shoppingDto.getPurchaseDetail().stream().anyMatch(pd -> pd.getId().equals(detail.getId())))
                        .forEach(purchaseDetailRepository::delete);

                return shoppingDto;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public void removed(Long id) {
        shoppingRepository.removeForId(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
        shoppingRepository.restoreForId(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        shoppingRepository.deleteById(id);
    }

}
