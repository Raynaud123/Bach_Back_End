package com.example.project.topic;

import com.example.project.keyword.Keyword;
import com.example.project.promotor.Promotor;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="promotor_id")
    @JsonIgnore
    private Promotor promotor;

    private Long aantal_studenten;
    @ManyToMany
//    @JsonIgnore
    private List<Keyword> keyword_list;
    @ManyToMany
    private List<Student> student_list;
    @ManyToMany
    private List<TargetAudience> targetAudience_list;
    private Boolean approved_topic;
    private Boolean hide_topic;
    private String description_topic;

    private Date release_date; // en enkel jaar weergeven


    public Topic(Long topic_id, String topicName, Long provider_id, Promotor promotor, Long aantal_studenten, List<Keyword> keyword_list, List<Student> student_list, List<TargetAudience> targetAudience_list, Boolean approved_topic, Boolean hide_topic, String description_topic, Date release_date) {
        this.topic_id = topic_id;
        this.topicName = topicName;
        this.provider_id = provider_id;
        this.promotor = promotor;
        this.aantal_studenten = aantal_studenten;
        this.keyword_list = keyword_list;
        this.student_list = student_list;
        this.targetAudience_list = targetAudience_list;
        this.approved_topic = approved_topic;
        this.hide_topic = hide_topic;
        this.description_topic = description_topic;
        this.release_date = release_date;
    }

    public Long getAantal_studenten() {
        return aantal_studenten;
    }

    public void setAantal_studenten(Long aantal_studenten) {
        this.aantal_studenten = aantal_studenten;
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


    public List<Keyword> getKeyword_list() {
        return keyword_list;
    }

    public void setKeyword_list(List<Keyword> keyword_id) {
        this.keyword_list = keyword_id;
    }

    public List<Student> getStudent_list() {
        return student_list;
    }

    public void setStudent_list(List<Student> student_id) {
        this.student_list = student_id;
    }

    public void addStudent(Student student) {
        this.student_list.add(student);
    }

    public List<TargetAudience> getTargetAudience_list() {
        return targetAudience_list;
    }

    public void setTargetAudience_list(List<TargetAudience> targetAudience_id) {
        this.targetAudience_list = targetAudience_id;
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

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }
}
