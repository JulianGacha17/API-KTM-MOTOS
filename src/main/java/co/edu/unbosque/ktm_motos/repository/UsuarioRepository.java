package co.edu.unbosque.ktm_motos.repository;

import co.edu.unbosque.ktm_motos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}