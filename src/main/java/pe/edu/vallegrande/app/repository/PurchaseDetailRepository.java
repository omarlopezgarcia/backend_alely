package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.app.model.entity.PurchaseDetail;

import java.util.List;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long> {

    @Query(value = "SELECT pd FROM PurchaseDetail pd WHERE pd.shopping.id=?1")
    List<PurchaseDetail> findByIdShopping(Long id);

    @Query("SELECT pd FROM PurchaseDetail pd WHERE pd.shopping.id = :shoppingId")
    List<PurchaseDetail> findByShoppingId(@Param("shoppingId") Long shoppingId);

}
