package co.edu.unbosque.ktm_motos.controller;

import co.edu.unbosque.ktm_motos.model.Usuario;
import co.edu.unbosque.ktm_motos.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> existente = usuarioService.buscarPorId(id);

        if (existente.isPresent()) {
            return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuario));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        Optional<Usuario> existente = usuarioService.buscarPorId(id);

        if (existente.isPresent()) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }

        return ResponseEntity.notFound().build();
    }
}