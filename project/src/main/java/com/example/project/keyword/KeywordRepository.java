package com.example.project.keyword;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

}
