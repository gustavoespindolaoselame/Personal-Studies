package alura.chatforum.chatforum.auth;
import alura.chatforum.chatforum.controller.UsuarioController;
import alura.chatforum.chatforum.model.Usuario;
import alura.chatforum.chatforum.repositories.UsuarioJpaRepository;
import alura.chatforum.chatforum.repositories.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    public String generateToken(String usuario) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create().withIssuer("API Voll.med").withSubject(usuario).sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean tokenVerifier(String token) {
        System.out.println("Token verified");
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("API Voll.med")
                    .build();
            return usuarioLookupToken(verifier.verify(token).getSubject());
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean usuarioLookupToken(String lookup){
        return usuarioJpaRepository.findAll().stream()
                .anyMatch(usuario -> usuario.getUsuario().equals(lookup));
    }
}
