package com.example.project.targetAudience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface TargetAudienceRepository extends JpaRepository<TargetAudience, Long> {
}
