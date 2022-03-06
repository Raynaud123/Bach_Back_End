package com.example.project.keyword;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Keyword {
    @SequenceGenerator(
            name = "keyword_sequence",
            sequenceName = "keyword_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "keyword_sequence"
    )
    private Long keyword_id;
    private String keyword_name;
}
