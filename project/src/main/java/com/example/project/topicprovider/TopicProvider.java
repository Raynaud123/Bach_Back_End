package com.example.project.topicprovider;


import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.notification.Notification;
import com.example.project.targetAudience.Campus;
import com.example.project.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.appuser.AppUserRole.COMPANY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("topicprovider")
public class TopicProvider extends AppUser implements Serializable{

    private boolean approved;
    private Boolean isCompany;//Company of Onderzoeksgroep
    @OneToMany
    private List<Company> begeleiders;
    private String name;
    @ManyToOne
    private Campus campus;          //Enkel nodig als het een onderzoeksgroep is



    public TopicProvider(boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(String username, String password, String email, String phoneNumber, AppUserRole appUserRole,  String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
 //       this.topic_list = topic_list;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
 //       this.topic_list = topic_list;
    }

    public TopicProvider(String username, String password, String email, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(username, password, email);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
  //      this.topic_list = topic_list;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(String username, String password, String email, boolean approved, Boolean isCompany, String name, Campus campus) {
        super(username, password, email);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, boolean approved, Boolean isCompany, String name, Campus campus) {
        super(id, username, password, email, phoneNumber, appUserRole,  country, city, streetName, postNumber, streetNumber, notification_list);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(boolean approved, Boolean isCompany, String name, Campus campus) {
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = campus;
    }

    public TopicProvider(String name, Boolean isCompany, Boolean approved) {
        super(COMPANY);
        this.approved = approved;
        this.isCompany = isCompany;
        this.name = name;
        this.campus = null;
        this.begeleiders = null;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        approved = approved;
    }

    public Boolean getCompany() {
        return isCompany;
    }

    public void setCompany(Boolean company) {
        isCompany = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Company> getBegeleiders() {
        return begeleiders;
    }

    public void setBegeleiders(List<Company> begeleiders) {
        this.begeleiders = begeleiders;
    }

    public void addBegeleider(Company c){
        begeleiders.add(c);
    }
}
