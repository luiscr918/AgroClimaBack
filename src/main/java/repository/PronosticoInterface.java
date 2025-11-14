package repository;

import entity.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PronosticoInterface extends JpaRepository<Pronostico,Long> {
}
