package com.example.project.subjectprovider;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface SubjectProviderRepository extends JpaRepository<SubjectProvider, Long> {

}
