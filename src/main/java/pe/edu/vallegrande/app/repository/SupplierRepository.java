package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT su FROM Supplier su WHERE su.status=?1 ORDER BY su.name ASC")
    List<Supplier> findByActiveSupplier(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Supplier su SET su.status='I' WHERE su.id=?1")
    void removeById(Long id);


    @Modifying
    @Transactional
    @Query("UPDATE Supplier su SET su.status='A' WHERE su.id=?1")
    void restoreById(Long id);

}
