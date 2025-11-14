package repository;

import entity.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacionInterface extends JpaRepository<Recomendacion,Long> {
}
