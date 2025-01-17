package alura.chatforum.chatforum.auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;
import alura.chatforum.chatforum.model.Usuario;

@Service
public class TokenGenerator {
    public static String generateToken(String usuario) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create().withIssuer("API Voll.med").withSubject(usuario).sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }
    public static void tokenVerifier(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(token);
            System.out.println(decodedJWT);
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
        }
    }
}
