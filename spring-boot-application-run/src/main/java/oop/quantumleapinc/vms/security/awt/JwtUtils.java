package oop.quantumleapinc.vms.security.awt;

import oop.quantumleapinc.vms.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;

//    public String getJwtFromCookies(HttpServletRequest request) {
//        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
//        if (cookie != null) {
//            return cookie.getValue();
//        } else {
//            return null;
//        }
//    }

    public String getJwtFromHeader(HttpServletRequest request) {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if ((header == null) || !header.startsWith("Bearer ")) {
            return null;
        }

        return header.split(" ")[1].trim();
    }

    public String generateJwt(UserDetailsImpl userPrincipal) {
        return generateTokenFromUsername(userPrincipal.getUsername());
    }

//    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
//        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
//        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
//        return cookie;
//    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
//        byte[] secret = Base64.getEncoder().encode(jwtSecret.getBytes());
//        SecretKey secretKey = Keys.hmacShaKeyFor(secret);
//        System.out.println("getUserNameFromJwtToken " + Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        return parseAuthToken(token).getSubject();
    }

    public Date getExpiryDateFromJwtToken(String token) {
//        byte[] secret = Base64.getEncoder().encode(jwtSecret.getBytes());
//        SecretKey secretKey = Keys.hmacShaKeyFor(secret);
//        System.out.println("getUserNameFromJwtToken " + Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
        return parseAuthToken(token).getExpiration();
    }

    private Claims parseAuthToken(String token) {
        byte[] secret = Base64.getEncoder().encode(jwtSecret.getBytes());
        SecretKey secretKey = Keys.hmacShaKeyFor(secret);
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String authToken) {
        final Date expiration = getExpiryDateFromJwtToken(authToken);
        return expiration.before(new Date());
    }

    public boolean validateJwtToken(String authToken) {
        try {
            byte[] secret = Base64.getEncoder().encode(jwtSecret.getBytes());
            SecretKey secretKey = Keys.hmacShaKeyFor(secret);
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            //Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            System.out.println("validateJwtToken " + Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody().getSubject());

            if (isTokenExpired(authToken)) {
                return false;
            }

            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromUsername(String username) {
        byte[] secret = Base64.getEncoder().encode(jwtSecret.getBytes());
        SecretKey secretKey = Keys.hmacShaKeyFor(secret);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(secretKey)
                .compact();
    }

    //.signWith(SignatureAlgorithm.HS512, jwtSecret)
}