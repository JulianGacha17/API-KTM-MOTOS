package co.edu.unbosque.ktm_motos.controller;

import co.edu.unbosque.ktm_motos.model.Usuario;
import co.edu.unbosque.ktm_motos.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioEncontrado =
                usuarioService.login(usuario.getCorreo(), usuario.getPassword());

        if (usuarioEncontrado.isPresent()) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Login exitoso");
            respuesta.put("usuario", usuarioEncontrado.get());
            return ResponseEntity.ok(respuesta);
        }

        Map<String, String> error = new HashMap<>();
        error.put("mensaje", "Credenciales incorrectas");
        return ResponseEntity.status(401).body(error);
    }
}