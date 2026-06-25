package service;

import dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO create(UsuarioDTO dto);
    UsuarioDTO update(Long id, UsuarioDTO dto);
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(Long id);
    void delete(Long id);
}
