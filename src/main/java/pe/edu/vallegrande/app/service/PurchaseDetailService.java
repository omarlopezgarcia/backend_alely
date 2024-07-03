package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.entity.PurchaseDetail;

import java.util.List;

public interface PurchaseDetailService {

    List<PurchaseDetail> getAll();
    PurchaseDetail getForId(Long id);
    List<PurchaseDetail> getForIdShopping(Long id);
    void delete(Long id);

}
