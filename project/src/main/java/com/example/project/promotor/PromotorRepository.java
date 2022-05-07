package com.example.project.promotor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Long> {

    Promotor findById(long id);

}
