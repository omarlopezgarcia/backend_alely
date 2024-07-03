package pe.edu.vallegrande.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.app.model.entity.CategoryType;

import java.util.List;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {
}
