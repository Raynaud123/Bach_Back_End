package com.example.project.Master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

}
