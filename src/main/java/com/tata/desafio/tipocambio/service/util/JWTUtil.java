package com.tata.desafio.tipocambio.service.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tata.desafio.tipocambio.model.Cliente;

public class JWTUtil {
    private static final String key = "PAASSSSWORR123";
    public static String gereratedJWT(Cliente cliente){

        Algorithm algorithm = Algorithm.HMAC256(key);
        String token = JWT.create()
                .withClaim("id", cliente.getId())
                .withClaim("mail", cliente.getCorreo())
                .withIssuer("auth0")
                .sign(algorithm);
        return token;
    }
    public static long Decode(String token){
        String[] parts = token.split(" ");
        token = parts[1];
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("id").asLong();
    }
}
