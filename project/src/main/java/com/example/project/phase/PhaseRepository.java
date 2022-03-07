package com.example.project.phase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long> {

}
