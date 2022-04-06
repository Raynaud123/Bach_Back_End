package com.example.project.topicprovider;


import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("topicprovider")
public class TopicProvider extends AppUser implements Serializable{


//    @SequenceGenerator(
//            name = "subjectProvider_sequence",
//            sequenceName = "subjectProvider_sequence",
//            allocationSize = 1
//    )
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "subjectProvider_sequence"
//    )

//    private Long TopicProvider_id;
    private boolean Approved;
    private String TypeProvider;    //Company of Onderzoeksgroep
    private String Name;

    public TopicProvider(boolean approved, String typeProvider, String name) {
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }

    public TopicProvider(String userName, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, String name) {
        super(userName, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }

    public TopicProvider(String userName, String password, String email, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, String name) {
        super(userName, password, email, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }

    public TopicProvider(String userName, String password, String email, String phoneNumber, AppUserRole user, boolean approved, String typeProvider, String name) {
        super(userName, password, email, phoneNumber, user);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }

    public TopicProvider(String userName, String password, String email, AppUserRole user, boolean approved, String typeProvider, String name) {
        super(userName, password, email, user);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }
}
