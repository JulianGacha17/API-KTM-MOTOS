package co.edu.unbosque.ktm_motos.service;

import co.edu.unbosque.ktm_motos.model.Usuario;
import co.edu.unbosque.ktm_motos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        usuarioActualizado.setId(id);
        return usuarioRepository.save(usuarioActualizado);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> login(String correo, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);

        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }

        return Optional.empty();
    }
}