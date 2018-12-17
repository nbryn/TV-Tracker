package com.niklas.tvtracker.security;

import com.niklas.tvtracker.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.niklas.tvtracker.security.SecurityCockpit.EXPIRATION_TIME;
import static com.niklas.tvtracker.security.SecurityCockpit.SECRET;

@Component
public class JwtTokenProvider {

    public String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap();
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expire = new Date(now.getTime()+EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullName());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
