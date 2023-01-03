package com.nabil.SystemRecrutement.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.nabil.SystemRecrutement.model.auth.ExtendedUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
// ce service qui va permet de générer le token et sa valisation ou expiraration 
public class JwtUtil {
	
	// pour générer un token on doit avoire un SECRET_KEY
	 private String SECRET_KEY = "secret";

	 // cette methode va extraire le user name 
	  public String extractUsername(String token) {
	    return extractClaim(token, Claims::getSubject);
	  }

	  // extraire la date  d'expiration
	  public Date extractExpiration(String token) {
	    return extractClaim(token, Claims::getExpiration);
	  }

	  // extraire la IdEntreprise
	  public String extractIdEntreprise(String token) {
	    final Claims claims = extractAllClaims(token);

	    return claims.get("idEntreprise", String.class);
	  }

	  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	    final Claims claims = extractAllClaims(token);
	    return claimsResolver.apply(claims);
	  }

	  private Claims extractAllClaims(String token) {
	    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	  }

	  private Boolean isTokenExpired(String token) {
	    return extractExpiration(token).before(new Date());
	  }

	  // la methode qui va générer le token il va appelle a la methode createToken 
	  public String generateToken(ExtendedUser userDetails) {
	    Map<String, Object> claims = new HashMap<>();
	    return createToken(claims, userDetails);
	  }

	  private String createToken(Map<String, Object> claims, ExtendedUser userDetails) {

	    return Jwts.builder().setClaims(claims)
	        .setSubject(userDetails.getUsername())
	        .setIssuedAt(new Date(System.currentTimeMillis()))
	        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	        // on va stoker idEntreprise dans le token pour etre valide  et pour utilisé dans l'intercepteur  
	        .claim("idEntreprise", userDetails.getIdEntreprise().toString())
	        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	  }

	  // cette methode permet de verifier  le token a ce que valide ou non 
	  public Boolean validateToken(String token, UserDetails userDetails) {
	    final String username = extractUsername(token);
	    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	  }

}