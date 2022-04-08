package com.example.project.topicprovider;


import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

    public TopicProvider(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, String name) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }

    public TopicProvider(String username, String password, String email, boolean approved, String typeProvider, String name) {
        super(username, password, email);
        Approved = approved;
        TypeProvider = typeProvider;
        Name = name;
    }
}
