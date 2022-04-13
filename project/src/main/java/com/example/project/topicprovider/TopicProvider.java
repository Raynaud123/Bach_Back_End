package com.example.project.topicprovider;


import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.targetAudience.Campus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("topicprovider")
public class TopicProvider extends AppUser implements Serializable{

    private boolean Approved;
    private String TypeProvider;    //Company of Onderzoeksgroep
    private String Name;
    @ManyToOne
    private Campus campus;          //Enkel nodig als het een onderzoeksgroep is

    public TopicProvider(boolean approved, String typeProvider, String name, Campus campus) {
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
        this.campus = campus;
    }

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, String name, Campus campus) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
        this.campus = campus;
    }

    public TopicProvider(String username, String password, String email, boolean approved, String typeProvider, String name, Campus campus) {
        super(username, password, email);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
        this.campus = campus;
    }

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean approved) {
        Approved = approved;
    }

    public String getTypeProvider() {
        return TypeProvider;
    }

    public void setTypeProvider(String typeProvider) {
        TypeProvider = typeProvider;
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
