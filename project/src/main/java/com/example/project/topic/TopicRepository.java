package com.example.project.topic;

import com.example.project.promotor.Promotor;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {


//    @Query(value = "SELECT t from TargetAudience t where id=?1")
    List<Topic>findByTargetAudiences(TargetAudience t);

    List<Topic> findByPromotor(Promotor id);

    List<Topic> findByProvider(long id);
}
