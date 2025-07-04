package com.xh;

import io.jsonwebtoken.*;
import jakarta.security.auth.message.AuthException;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest  {
    @Test
    public void JWTGenerator() {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", 1);
        claims.put("username", "Tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "enetgterfre")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12*3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void JWTVerifier()throws Exception {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("enetgterfre")
                    .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJUb20iLCJleHAiOjE3NTE2MDg4NTN9.-2R81dl6wLcY_HXaZgqMrokCU8CQLxgVL5Z8rAWpFG4")
                    .getBody();
            System.out.println(claims);
        } catch (SignatureException  e) {
            throw new AuthException("Token签名无效");
        }
    }
}
