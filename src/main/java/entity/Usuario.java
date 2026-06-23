package entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Usuario {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    @ManyToOne
    private Rol rol;
    @OneToOne
    private Empleado empleado;
}
