package com.example.project.targetAudience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Campus {
    @SequenceGenerator(
            name = "campus_sequence",
            sequenceName = "campus_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "campus_sequence"
    )
    private Long campus_id;
    private String campus_name;
    private String country;
    private Integer postNumber;
    private String City;
    private String streetName;
    private Integer streetNumber;
}
