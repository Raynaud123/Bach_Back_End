package com.example.project.topicprovider;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface TopicProviderRepository extends JpaRepository<TopicProvider, Long> {


    @Query("SELECT t FROM TopicProvider t where t.email =?1")
    Optional<TopicProvider> findTopicProviderByEmail(String Email);
}
