package com.alexandruleonte.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.inject.Named;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Named
public class TokenIssuer {
    public static final long EXPIRY_MINS = 120L;
    public String issueToken(String username) {
        LocalDateTime expiryPeriod = LocalDateTime.now()
                .plusMinutes(EXPIRY_MINS);
        Date expirationDateTime = Date.from(
                expiryPeriod.atZone(ZoneId.systemDefault())
                        .toInstant());
        Key key = new SecretKeySpec("secret".getBytes(), "DES");
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, key)
                .setIssuedAt(new Date())
                .setExpiration(expirationDateTime)
                .compact();
    }
}
