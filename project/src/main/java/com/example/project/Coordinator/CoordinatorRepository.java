package com.example.project.Coordinator;

import com.example.project.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {

}
