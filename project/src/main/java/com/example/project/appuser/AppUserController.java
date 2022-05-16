package com.example.project.appuser;


import com.example.project.security.AuthenticationRequest;
import com.example.project.security.AuthenticationResponse;
import com.example.project.security.JwtUtil;
import com.example.project.topicprovider.Company;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "appuser")
public class AppUserController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserService service;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private TopicProviderRepository topicProviderRepository;


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
        final UserDetails userDetails = service.loadUserByUsername(authenticationrequest.getUsername());
        Optional<AppUser> appUser = service.loadUserByUsernameApp(authenticationrequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getAuthorities(), appUser.get().getId()));

    };

    @PostMapping(path = "/register")
    public AppUser register(@RequestBody RegisterRequest registerRequest) throws Exception {
        TopicProvider test;
        try {
            test = new TopicProvider(registerRequest.getUsername(), registerRequest.getPassword());
            topicProviderRepository.save(test);
        } catch (Exception e) {
            throw new Exception("Registration Failed");
        }

        return test;
    }

    @GetMapping("/{id}")
    public AppUser getAppuserById(@PathVariable Long id) {
        return appUserRepository.findById(id).get();
    }

}
