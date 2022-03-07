package com.example.project.admin;

import com.example.project.topicprovider.TopicProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
