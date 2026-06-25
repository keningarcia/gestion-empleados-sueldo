package repository;

import entity.DetalleSueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleSueldoRepository extends JpaRepository<DetalleSueldo, Long> {
    List<DetalleSueldo> findByNominaId(Long sueldoId);
}
