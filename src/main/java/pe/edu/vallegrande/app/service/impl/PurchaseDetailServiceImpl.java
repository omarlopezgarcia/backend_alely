package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.app.model.entity.PurchaseDetail;
import pe.edu.vallegrande.app.service.PurchaseDetailService;
import pe.edu.vallegrande.app.repository.PurchaseDetailRepository;
import pe.edu.vallegrande.app.repository.ProductsRepository;

import java.util.List;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public List<PurchaseDetail> getAll() {
        return purchaseDetailRepository.findAll();
    }

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public PurchaseDetail getForId(Long id) {
        return purchaseDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseDetail> getForIdShopping(Long id) {
        return purchaseDetailRepository.findByIdShopping(id);
    }

    @Override
    public void delete(Long id) {
        purchaseDetailRepository.deleteById(id);
    }

}
