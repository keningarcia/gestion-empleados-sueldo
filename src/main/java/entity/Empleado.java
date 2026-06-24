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
public class Empleado extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = false)
    private BigDecimal salarioBase;

    @Column(nullable = false)
    private Boolean activo;

    @ManyToOne
    private Area area;

    @OneToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "empleado")
    private List<Sueldo> sueldos;
}
