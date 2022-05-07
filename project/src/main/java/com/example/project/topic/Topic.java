package com.example.project.topic;

import com.example.project.appuser.AppUser;
import com.example.project.keyword.Keyword;
import com.example.project.promotor.Promotor;
import com.example.project.student.Student;
import com.example.project.student.Topic_choice;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topicprovider.TopicProvider;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name="provider_id")
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private AppUser provider;


    @OneToMany(
            mappedBy = "topic",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Topic_choice> tags = new ArrayList<>();


    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    Student boostedStudent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promotor_id")
    private Promotor promotor;

    private Long aantal_studenten;
    @ManyToMany
    private List<Keyword> keyword_list;
    @ManyToMany
    private List<Student> student_list;
    @ManyToMany
    private List<TargetAudience> targetAudience_list;


    private Boolean approved_topic;
    private Boolean hide_topic;
    private String description_topic;

    private Date release_date; // en enkel jaar weergeven

    public Topic(Long topic_id, String topicName, AppUser provider, Promotor promotor, Long aantal_studenten, List<Keyword> keyword_list, List<Student> student_list, List<TargetAudience> targetAudience_list, Boolean approved_topic, Boolean hide_topic, String description_topic, Date release_date) {
        this.topic_id = topic_id;
        this.topicName = topicName;
        this.provider = provider;
        this.tags = tags;
        this.boostedStudent = boostedStudent;
        this.promotor = promotor;
        this.aantal_studenten = aantal_studenten;
        this.keyword_list = keyword_list;
        this.student_list = student_list;
        this.targetAudience_list = targetAudience_list;
        this.approved_topic = approved_topic;
        this.hide_topic = false;
        this.boostedStudent = null;
        this.description_topic = description_topic;
        this.release_date = release_date;
    }

    public Topic(String topicName, String description_topic, long aantal_studenten, List<Keyword> keywords, List<TargetAudience> targetAudiences, AppUser provider) {
        this.topicName = topicName;
        this.provider = provider;
        this.aantal_studenten = aantal_studenten;
        this.keyword_list = keywords;
        this.targetAudience_list = targetAudiences;
        this.approved_topic = false;
        this.hide_topic = false;
        this.release_date = new Date();
        this.boostedStudent = null;
        this.description_topic = description_topic;
    }

    public Topic(String topicName, String description_topic, long aantal_studenten, AppUser appUser) {
        this.topicName = topicName;
        this.provider = appUser;
        this.aantal_studenten = aantal_studenten;
        this.keyword_list = null;
        this.targetAudience_list = null;
        this.approved_topic = false;
        this.hide_topic = false;
        this.release_date = new Date();
        this.boostedStudent = null;
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

    public AppUser getProvider() {
        return provider;
    }

    public void setProvider(TopicProvider provider) {
        this.provider = provider;
    }

    public List<Topic_choice> getTags() {
        return tags;
    }

    public void setTags(List<Topic_choice> tags) {
        this.tags = tags;
    }

    public Student getBoostedStudent() {
        return boostedStudent;
    }

    public void setBoostedStudent(Student boostedStudent) {
        this.boostedStudent = boostedStudent;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public Long getAantal_studenten() {
        return aantal_studenten;
    }

    public void setAantal_studenten(Long aantal_studenten) {
        this.aantal_studenten = aantal_studenten;
    }

    public List<Keyword> getKeyword_list() {
        return keyword_list;
    }

    public void setKeyword_list(List<Keyword> keyword_list) {
        this.keyword_list = keyword_list;
    }

    public List<Student> getStudent_list() {
        return student_list;
    }

    public void setStudent_list(List<Student> student_list) {
        this.student_list = student_list;
    }

    public List<TargetAudience> getTargetAudience_list() {
        return targetAudience_list;
    }

    public void setTargetAudience_list(List<TargetAudience> targetAudience_list) {
        this.targetAudience_list = targetAudience_list;
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




    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", topicName='" + topicName + '\'' +
                ", provider_id=" + provider +
                ", aantal_studenten=" + aantal_studenten +
                ", keyword_list=" + keyword_list +
                ", student_list=" + student_list +
                ", targetAudience_list=" + targetAudience_list +
                ", approved_topic=" + approved_topic +
                ", hide_topic=" + hide_topic +
                ", description_topic='" + description_topic + '\'' +
                ", release_date=" + release_date +
                '}';
    }


    public void addStudent(Student student) {
        this.student_list.add(student);
    }
}
