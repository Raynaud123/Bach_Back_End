package com.example.project.appuser;

import com.example.project.notification.Notification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
public class AppUser implements UserDetails {

    @SequenceGenerator(
            name = "appUser_sequence",
            sequenceName = "appUser_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appUser_sequence"
    )
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean hide = false;

    private String country;
    private String city;
    private String streetName;
    private Integer postNumber;
    private Integer streetNumber;

    @OneToMany
    private List<Notification> notification_list;

    public AppUser(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appUserRole = appUserRole;
        this.hide = false;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.postNumber = postNumber;
        this.streetNumber = streetNumber;
    }

    public AppUser(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appUserRole = appUserRole;
        this.hide = false;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.postNumber = postNumber;
        this.streetNumber = streetNumber;
    }

    public AppUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public AppUser(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appUserRole = appUserRole;
        this.hide = false;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.postNumber = postNumber;
        this.streetNumber = streetNumber;
        this.notification_list = notification_list;
    }

    public AppUser(String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appUserRole = appUserRole;
        this.hide = false;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.postNumber = Math.toIntExact(postNumber);
        this.streetNumber = Math.toIntExact(streetNumber);
    }

    public AppUser(AppUserRole a) {
        this.username = null;
        this.password = null;
        this.email = null;
        this.phoneNumber = null;
        this.appUserRole = a;
        this.hide = false;
        this.country = null;
        this.city = null;
        this.streetName = null;
        this.postNumber = null;
        this.streetNumber = null;
        this.notification_list = null;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Notification> getNotification_list() {
        return notification_list;
    }

    public void setNotification_list(List<Notification> notification_list) {
        this.notification_list = notification_list;
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appUserRole=" + appUserRole +
                ", hide=" + hide +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postNumber=" + postNumber +
                ", streetNumber=" + streetNumber +
                ", notification_list=" + notification_list +
                '}';
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
