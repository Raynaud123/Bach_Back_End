package com.example.project.targetAudience;

import com.example.project.keyword.Keyword;
import com.example.project.student.Student;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TargetAudience {
    @SequenceGenerator(
            name = "targetAudience_sequence",
            sequenceName = "targetAudience_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "targetAudience_sequence"
    )
    private Long targetAudience_id;
    @OneToMany
    private List<Campus> campus;
    @OneToMany
    private List<Course> course;
    private Boolean hide_targetAudience;


}
