package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.app.model.entity.HumanResources;

import java.util.List;

@Repository
public interface HumanResourcesRepository extends JpaRepository<HumanResources, Long> {
    @Query(value = "SELECT h FROM HumanResources h WHERE h.status=?1 ORDER BY h.name ASC")
    List<HumanResources> findByActiveHumanResources(String status);

    @Modifying
    @Transactional
    @Query("UPDATE HumanResources h SET h.status='I' WHERE h.id=?1")
    void removeById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE HumanResources h SET h.status='A' WHERE h.id=?1")
    void restoreById(Long id);
}
