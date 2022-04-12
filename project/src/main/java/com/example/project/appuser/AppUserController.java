package com.example.project.appuser;


import com.example.project.security.AuthenticationRequest;
import com.example.project.security.AuthenticationResponse;
import com.example.project.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "appuser")
public class AppUserController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserService service;


    @Autowired
    private JwtUtil jwtTokenUtil;


    @PostMapping(path = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationrequest) throws Exception{

        try{
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername(), authenticationrequest.getPassword(),new ArrayList<>()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        // Misschien appuser inplaats an userDetails?
        final UserDetails appUser = service.loadUserByUsername(authenticationrequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(appUser);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, appUser.getAuthorities()));

    };

    @PostMapping(path = "/register")
    public AppUser register(@RequestBody RegisterRequest registerRequest) throws Exception {
        AppUser test;
        try {
            test = new AppUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail());
            service.singUpUser(test);
        } catch (Exception e) {
            throw new Exception("Registration Failed");
        }

        return test;
    }

}
