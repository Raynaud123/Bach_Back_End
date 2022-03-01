package com.example.project.topic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Topic {

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
    private Long provider_topic_id;
    private Long promotor_topic_id;
    private Long coordinator_topic_id;
    private Long keyword_topic_id;
    private Boolean approved_topic;
    private Boolean hide_topic;
    private String description_topic_id;

    public Topic(Long provider_topic_id, Long promotor_topic_id, Long coordinator_topic_id,
                    Long keyword_topic_id, Boolean approved_topic, Boolean hide_topic, String description_topic_id) {
        this.promotor_topic_id = promotor_topic_id;
        this.provider_topic_id = provider_topic_id;
        this.coordinator_topic_id = coordinator_topic_id;
        this.keyword_topic_id = keyword_topic_id;
        this.approved_topic = approved_topic;
        this.hide_topic = hide_topic;
        this.description_topic_id = description_topic_id;
    }

    public Long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public Long getProvider_topic_id() {
        return provider_topic_id;
    }

    public void setProvider_topic_id(Long provider_topic_id) {
        this.provider_topic_id = provider_topic_id;
    }

    public Long getPromotor_topic_id() {
        return promotor_topic_id;
    }

    public void setPromotor_topic_id(Long promotor_topic_id) {
        this.promotor_topic_id = promotor_topic_id;
    }

    public Long getCoordinator_topic_id() {
        return coordinator_topic_id;
    }

    public void setCoordinator_topic_id(Long coordinator_topic_id) {
        this.coordinator_topic_id = coordinator_topic_id;
    }

    public Long getKeyword_topic_id() {
        return keyword_topic_id;
    }

    public void setKeyword_topic_id(Long keyword_topic_id) {
        this.keyword_topic_id = keyword_topic_id;
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

    public String getDescription_topic_id() {
        return description_topic_id;
    }

    public void setDescription_topic_id(String description_topic_id) {
        this.description_topic_id = description_topic_id;
    }
}
