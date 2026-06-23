package entity;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Cargo {
    private Long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "cargo")
    private List<Empleado> empleados;
}
