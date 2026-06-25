package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Boolean enabled;
    @NotBlank
    private String rol;
    private Long empleadoId;
}
