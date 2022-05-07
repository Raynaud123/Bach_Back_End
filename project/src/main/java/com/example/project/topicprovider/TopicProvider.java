package com.example.project.topicprovider;


import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
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

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("topicprovider")
public class TopicProvider extends AppUser implements Serializable{

    private boolean Approved;
    private Boolean isCompany;    //Company of Onderzoeksgroep
    private String Name;
    @ManyToOne
    private Campus campus;          //Enkel nodig als het een onderzoeksgroep is
    @OneToMany(mappedBy="provider",cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "topic_id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Topic> topic_list;


    public TopicProvider(boolean approved, Boolean isCompany, String name, Campus campus) {
        Approved = approved;
        this.isCompany = isCompany;
        Name = name;
        this.campus = campus;
        this.topic_list = new ArrayList<>();
    }

    public TopicProvider(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        this.isCompany = isCompany;
        Name = name;
        this.campus = campus;
        this.topic_list = topic_list;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        this.isCompany = isCompany;
        Name = name;
        this.campus = campus;
        this.topic_list = topic_list;
    }

    public TopicProvider(String username, String password, String email, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list) {
        super(username, password, email);
        Approved = approved;
        this.isCompany = isCompany;
        Name = name;
        this.campus = campus;
        this.topic_list = topic_list;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        this.isCompany = isCompany;
        Name = name;
        this.campus = campus;
    }

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean approved) {
        Approved = approved;
    }

    public Boolean getCompany() {
        return isCompany;
    }

    public void setCompany(Boolean company) {
        isCompany = company;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}
