package com.example.project.admin;

import com.example.project.topicprovider.TopicProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
