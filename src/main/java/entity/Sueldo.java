package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sueldo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private BigDecimal salarioBase;

    @Column(nullable = false)
    private BigDecimal totalBonificaciones;

    @Column(nullable = false)
    private BigDecimal totalDescuentos;

    @Column(nullable = false)
    private BigDecimal salarioNeto;

    @ManyToOne
    private Empleado empleado;

    @OneToMany(mappedBy = "nomina")
    private List<DetalleSueldo> detalles;
}
