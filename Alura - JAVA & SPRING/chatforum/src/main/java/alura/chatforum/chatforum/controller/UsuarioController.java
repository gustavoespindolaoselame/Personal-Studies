package alura.chatforum.chatforum.controller;

import alura.chatforum.chatforum.auth.TokenService;
import alura.chatforum.chatforum.model.Usuario;
import alura.chatforum.chatforum.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class UsuarioController {

    TokenService tokenService = new TokenService();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping()
    public void registerUsuario(@RequestBody Usuario request) {
        usuarioRepository.save(new Usuario(request.getMensagem(), request.getNomeCurso()));
    }
}
