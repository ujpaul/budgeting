package com.budgeting.burdgetmanagement.service;/*
 *Reference https://www.codota.com/code/java/methods/io.jsonwebtoken.Jwts/parser
 *
 */

/**
 * @author user
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.budgeting.burdgetmanagement.utilities.GeneralLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.*;

import java.security.SignatureException;
import java.util.Date;
import java.util.UUID;
import java.util.Base64;


@Service
public class JwtProvider {
    private static Logger logger = LoggerFactory.getLogger(GeneralLogger.class);
    private static String rawSecretKey = "comza!buget@managementRND!@#$paul2022@buget@managementRND!@#$paul2022!comza!buget@managementRND!@#$paul2022@buget";
    private static String SECRET_KEY = Base64.getEncoder().encodeToString(rawSecretKey.getBytes());;

    public boolean isValidToken(String token) {
        try {
            
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);

            if (getUserName(token).trim().length() > 0) {
                return true;
            }

            return false;
        } catch (MalformedJwtException e) {
            logger.info("Invalid JWT token.");
            logger.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            logger.info("Expired JWT token.");
            logger.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.info("Unsupported JWT token.");
            logger.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            logger.info("JWT token compact of handler are invalid.");
            logger.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public String createJwtToken(String username) {
        System.out.println("Incoming username:"+ username);
        try {

            String token = Jwts.builder().setSubject(username)
                    .setIssuer("paul@test.com")
                    .setIssuedAt(new Date())
                    .setId(UUID.randomUUID().toString())
                    .setExpiration(new Date(System.currentTimeMillis() + (3600000 * 5)))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
            return token;

        } catch (Exception ex) {
            System.out.println("Token not created:" + ex.getMessage());
//            logger.error("ERROR:" + ex.getMessage());
            return "";
        }

    }



    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.error(token + "|" + getStackString(e));
        }
        return claims;
    }

   private boolean isJWTExpired(DecodedJWT decodedJWT) {
        Date expiresAt = decodedJWT.getExpiresAt();
        return expiresAt.before(new Date());
    }

    public  Date getExpiryDate(String token){
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return  decodedJWT.getExpiresAt();
        } catch (JWTVerificationException e) {
            // ...
        }
        return  null;
    }

    private boolean isTokenValid(String token) {
        Claims claims = getClaimsFromToken(token);

        if (claims != null)
            return true;
        else
            return false;
    }

    public String getUserName(String token) {
        String username = "";
        Claims claims = getClaimsFromToken(token);

        if (claims != null) {
            username = claims.getSubject();
        }


        return username;
    }

    public String getStackString(Exception ex) {
        String errorStackTrace = "";
        StackTraceElement[] stack = ex.getStackTrace();
        for (StackTraceElement stack1 : stack) {
            if (errorStackTrace.length() == 0) {
                errorStackTrace = errorStackTrace + stack1.toString();
            } else {
                errorStackTrace = errorStackTrace + "|" + stack1.toString();
            }
        }
        return errorStackTrace;

    }
}
