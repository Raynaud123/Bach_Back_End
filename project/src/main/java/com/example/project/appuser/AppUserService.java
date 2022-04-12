package com.example.project.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
 //   private final org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> user = appUserRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getAppUserRole().name()));
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),authorities);

    }

    public Optional<AppUser> loadUserByUsernameApp(String username) throws UsernameNotFoundException{
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public Optional<AppUser> getUser(String email){
        return appUserRepository.findByEmail(email);
    }


    public AppUser saveUser(AppUser user){
        user.setPassword(user.getPassword());
        return appUserRepository.save(user);
    }

    public void singUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        boolean userNameExists = appUserRepository.findByUsername(appUser.getUsername()).isPresent();
        if (userExists) {
            // TODO: check if attributes are the same and

            throw new IllegalStateException("email already taken");
        }else if(userNameExists){
            throw new IllegalStateException("Username already taken");
        }

//        String encodedPassword =appUser.getPassword();
//        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

    }


    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

}
