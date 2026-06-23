package entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Empleado {
    private Long id;

    private String codigo;

    private String nombres;

    private String apellidos;

    private String dni;

    private String correo;

    private String telefono;

    private LocalDate fechaIngreso;

    private BigDecimal salarioBase;

    private Boolean activo;

    @ManyToOne
    private Area area;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "empleado")
    private List<Nomina> nominas;
}
