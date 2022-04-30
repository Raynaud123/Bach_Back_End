package com.example.project.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {




//    List<Student> getTop3_TopicsById(int topic_id);

}
