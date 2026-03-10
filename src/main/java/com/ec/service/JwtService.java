package com.ec.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
    private final String SECRET_KEY = "mySecretKey123456mySecretKey123456"; 
    // ★32文字以上必要（重要）
    
    private Key getSigningKey() {
    	return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
	
	public String generateToken(String email) {
		
		return Jwts.builder()
				.setSubject(email) // トークンの主役（ユーザー識別）
				.setIssuedAt(new Date()) // 発行時間
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1時間
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String extractUsername(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		
		return expiration.before(new Date());
	}
}
