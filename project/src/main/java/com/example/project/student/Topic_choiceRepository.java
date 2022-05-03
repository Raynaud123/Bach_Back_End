package com.example.project.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Topic_choiceRepository extends JpaRepository<Topic_choice, Long> {


    List<Topic_choice> findAllByStudent(Student s);

    List<Topic_choice> findByStudent(Student s);

}
