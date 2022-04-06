package com.example.project.appuser;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;
//
//    @Autowired
//    private TopicProviderService topicProviderService;
//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/{id}")
//    public TopicProvider getTopicprovider(@PathVariable Long id) {
//        return topicProviderService.getTopicProvider(id);
//    }

}
