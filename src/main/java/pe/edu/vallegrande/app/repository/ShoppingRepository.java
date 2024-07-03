package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.entity.Shopping;

import java.util.List;
@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {

    @Query(value = "SELECT s FROM Shopping s WHERE  s.status=?1 ORDER BY s.id DESC")
    List<Shopping> findByActiveShopping(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Shopping s SET s.status='I' WHERE s.id=?1")
    void removeForId(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Shopping s SET s.status='A' WHERE s.id=?1")
    void restoreForId(Long id);
}
