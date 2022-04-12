package com.example.project.Coordinator;

import com.example.project.keyword.Keyword;
import com.example.project.person.Person;
import com.example.project.promotor.Promotor;
import com.example.project.topic.Topic;
import com.example.project.topicprovider.TopicProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("master")
public class Coordinator extends Person implements Serializable {

    @SequenceGenerator(
            name = "master_sequence",
            sequenceName = "master_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "master_sequence"
    )
    private Long master_id;

    @ManyToMany
    private List<Topic> topic_list;
    @ManyToMany
    private List<TopicProvider> topicProvider_list;
    @ManyToMany
    private List<Promotor> promotor_list;
}
