package com.project1.example.config;

import java.security.Key;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.project1.example.domain.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import com.project1.example.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;

@SuppressWarnings("deprecation")
@Component
@RequiredArgsConstructor
public class JwtUtils {

	private static final String jwtSecret = "project1exampleproject1exampleproject1example";
	
	private static final int jwtExpirationMs = 864000;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public String generateJwtToken(Authentication authentication) {

		User user = (User) authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject((user.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
				.compact();
	}
	

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	 private static Claims getClaimsFormToken(String token) {
	        return (Claims) Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret))
	        		.parseClaimsJws(token).getBody();
	    }
	 
	 public static String getUserEmailFromToken(String token) {
	        Claims claims = getClaimsFormToken(token);
	        Map<String, Object> map = new HashMap<>(claims);
	        String username = (String) map.get("sub");
	        
	        return username;
	    }
	 
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
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
	
	
}


