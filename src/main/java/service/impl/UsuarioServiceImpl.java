package service.impl;

import dto.UsuarioDTO;
import entity.Empleado;
import entity.Rol;
import entity.Usuario;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EmpleadoRepository;
import repository.UsuarioRepository;
import service.UsuarioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEnabled(dto.getEnabled());
        usuario.setRol(Rol.valueOf(dto.getRol().toUpperCase()));

        if (dto.getEmpleadoId() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + dto.getEmpleadoId()));
            usuario.setEmpleado(empleado);
        }

        usuario = usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    @Override
    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id: " + id));

        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEnabled(dto.getEnabled());
        usuario.setRol(Rol.valueOf(dto.getRol().toUpperCase()));

        if (dto.getEmpleadoId() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + dto.getEmpleadoId()));
            usuario.setEmpleado(empleado);
        } else {
            usuario.setEmpleado(null);
        }

        usuario = usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id: " + id));
        return toDto(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario not found with id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                null,
                usuario.getEnabled(),
                usuario.getRol().name(),
                usuario.getEmpleado() != null ? usuario.getEmpleado().getId() : null
        );
    }
}
