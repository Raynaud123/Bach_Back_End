package com.example.project.topic;

import com.example.project.keyword.Keyword;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import lombok.EqualsAndHashCode;
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
public class Topic implements Serializable {

    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    private Long topic_id;

    private String topicName;
    //@ManyToOne
    private Long provider_id;
    //@ManyToMany
    private Long promotor_id;
    //@ManyToMany
    private Long coordinator_id;
    @ManyToMany
    private List<Keyword> keyword_id;
    @OneToMany
    private List<Student> student_id;
    @ManyToMany
    private List<TargetAudience> targetAudience_id;
    private Boolean approved_topic;
    private Boolean hide_topic;
    private String description_topic;


    public Topic(Long topic_id, String topicName, Long provider_id, Long promotor_id, Long coordinator_id,
                 List<Keyword> keyword_id, List<Student> student_id, List<TargetAudience> targetAudience_id,
                 Boolean approved_topic, Boolean hide_topic, String description_topic) {
        this.topic_id = topic_id;
        this.topicName = topicName;
        this.provider_id = provider_id;
        this.promotor_id = promotor_id;
        this.coordinator_id = coordinator_id;
        this.keyword_id = keyword_id;
        this.student_id = student_id;
        this.targetAudience_id = targetAudience_id;
        this.approved_topic = approved_topic;
        this.hide_topic = hide_topic;
        this.description_topic = description_topic;
    }

    public Long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }

    public Long getPromotor_id() {
        return promotor_id;
    }

    public void setPromotor_id(Long promotor_id) {
        this.promotor_id = promotor_id;
    }

    public Long getCoordinator_id() {
        return coordinator_id;
    }

    public void setCoordinator_id(Long coordinator_id) {
        this.coordinator_id = coordinator_id;
    }

    public List<Keyword> getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(List<Keyword> keyword_id) {
        this.keyword_id = keyword_id;
    }

    public List<Student> getStudent_id() {
        return student_id;
    }

    public void setStudent_id(List<Student> student_id) {
        this.student_id = student_id;
    }

    public List<TargetAudience> getTargetAudience_id() {
        return targetAudience_id;
    }

    public void setTargetAudience_id(List<TargetAudience> targetAudience_id) {
        this.targetAudience_id = targetAudience_id;
    }

    public Boolean getApproved_topic() {
        return approved_topic;
    }

    public void setApproved_topic(Boolean approved_topic) {
        this.approved_topic = approved_topic;
    }

    public Boolean getHide_topic() {
        return hide_topic;
    }

    public void setHide_topic(Boolean hide_topic) {
        this.hide_topic = hide_topic;
    }

    public String getDescription_topic() {
        return description_topic;
    }

    public void setDescription_topic(String description_topic) {
        this.description_topic = description_topic;
    }

}
