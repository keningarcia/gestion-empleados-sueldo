package entity;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Area {
    private Long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "area")
    private List<Empleado> empleados;
}
