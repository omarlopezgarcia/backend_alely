package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.entity.Products;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT p FROM Products p WHERE p.status=?1 ORDER BY p.name ASC")
    List<Products> findByActiveProduct(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Products p SET p.status='I' WHERE p.id=?1")
    void removeById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Products p SET p.status='A' WHERE p.id=?1")
    void restoreById(Long id);
}
