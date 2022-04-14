package com.example.project.topic;

import com.example.project.promotor.Promotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {


    List<Topic> findByPromotor(Promotor id);
}
