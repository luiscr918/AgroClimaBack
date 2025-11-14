package repository;

import entity.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivoInterface extends JpaRepository<Cultivo,Long> {
}
