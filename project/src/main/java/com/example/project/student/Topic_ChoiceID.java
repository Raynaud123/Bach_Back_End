//package com.example.project.student;
//
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class Topic_ChoiceID implements Serializable {
//
//
//    @Column(name = "topic_id")
//    private Long topic_id;
//
//    @Column(name = "student_id")
//    private Long student_id;
//
//
//    public Topic_ChoiceID(Long topic_id, Long student_id) {
//        this.topic_id = topic_id;
//        this.student_id = student_id;
//    }
//
//    public Topic_ChoiceID() {
//
//    }
//
//
//    public Long getTopic_id() {
//        return topic_id;
//    }
//
//    public void setTopic_id(Long topic_id) {
//        this.topic_id = topic_id;
//    }
//
//    public Long getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(Long student_id) {
//        this.student_id = student_id;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        Topic_ChoiceID that = (Topic_ChoiceID) o;
//        return Objects.equals(student_id, that.student_id) &&
//                Objects.equals(topic_id, that.topic_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(topic_id, student_id);
//    }
//}
