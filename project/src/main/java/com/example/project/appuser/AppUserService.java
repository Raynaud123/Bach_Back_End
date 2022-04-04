package com.example.project.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.example.project.appuser.AppUserRole.ADMIN;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
 //   private final org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<AppUser> user = appUserRepository.findByEmail(email);
//        if(user.isEmpty()){
//            throw new UsernameNotFoundException("User not found");
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.get().getAppUserRole().name()));
//        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(),authorities);

        return new AppUser("raynaud","1234","raynaud.cornille@gmail.com","585858",ADMIN, false,true,"Belgium","Veldegem","Rembertstraat",8,99);

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
        if (userExists) {
            // TODO: check if attributes are the same and

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword =appUser.getPassword();
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
