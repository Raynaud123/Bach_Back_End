package com.example.project.Coordinator;

import com.example.project.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("coordinator")
public class Coordinator extends Person implements Serializable {


}
