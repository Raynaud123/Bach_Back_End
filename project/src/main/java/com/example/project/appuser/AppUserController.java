package com.example.project.appuser;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "appuser")
public class AppUserController {

    @Autowired
    private AppUserService service;

    @GetMapping("/refreshtoken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token =authorizationHeader.substring("Bearer ".length());
                //TODO: Secret woord moet nog vervangen worden anders niet veilig
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String email = decodedJWT.getSubject();
                AppUser user = service.getUser(email).get();
                String acces_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ 10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", Collections.singletonList(user.getAppUserRole().name()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                Cookie cookie = new Cookie("refresh_token",refresh_token);
                cookie.setMaxAge(60*60);
                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
//        response.setHeader("refresh_token", refresh_token);
                tokens.put("acces_token", acces_token);
                //       tokens.put("refresh_token", refresh_token);
                tokens.put("roles", String.valueOf(user.getAuthorities()));
                response.setContentType((APPLICATION_JSON_VALUE));
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }
            catch (Exception e){
                response.setHeader("error" , e.getMessage());
                response.sendError(FORBIDDEN.value());
            }
        }else {
            throw new RuntimeException("Refresh token is missing");
        }
    }



}
