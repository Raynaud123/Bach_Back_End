package com.example.project.phase;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Phase {

    @SequenceGenerator(
            name = "phase_sequence",
            sequenceName = "phase_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phase_sequence"
    )
    private Long phase_id;
    private String phase_name;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begin_deadline;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_deadline;
    private Boolean firstRound;
    private Boolean hide;


    public Phase(Long phase_id, String phase_name, Date begin_deadline, Date end_deadline, Boolean firstRound, Boolean hide) {
        this.phase_id = phase_id;
        this.phase_name = phase_name;
        this.begin_deadline = begin_deadline;
        this.end_deadline = end_deadline;
        this.firstRound = firstRound;
        this.hide = hide;
    }

    public Phase(String phase_name, Date begin_deadline, Date end_deadline, Boolean firstRound, Boolean hide) {
        this.phase_name = phase_name;
        this.begin_deadline = begin_deadline;
        this.end_deadline = end_deadline;
        this.firstRound = firstRound;
        this.hide = hide;
    }

    public Long getPhase_id() {
        return phase_id;
    }

    public void setPhase_id(Long phase_id) {
        this.phase_id = phase_id;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public Date getBegin_deadline() {
        return begin_deadline;
    }

    public void setBegin_deadline(Date begin_deadline) {
        this.begin_deadline = begin_deadline;
    }

    public Date getEnd_deadline() {
        return end_deadline;
    }

    public void setEnd_deadline(Date end_deadline) {
        this.end_deadline = end_deadline;
    }

    public Boolean getFirstRound() {
        return firstRound;
    }

    public void setFirstRound(Boolean firstRound) {
        this.firstRound = firstRound;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
