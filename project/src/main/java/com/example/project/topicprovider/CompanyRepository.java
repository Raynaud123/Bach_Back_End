package com.example.project.topicprovider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findById(long id);
}
