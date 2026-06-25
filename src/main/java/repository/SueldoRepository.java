package repository;

import entity.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SueldoRepository extends JpaRepository<Sueldo, Long> {
    List<Sueldo> findByEmpleadoId(Long empleadoId);
}
