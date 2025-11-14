package repository;

import entity.Siembra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiembraInterface extends JpaRepository<Siembra,Long> {
}
