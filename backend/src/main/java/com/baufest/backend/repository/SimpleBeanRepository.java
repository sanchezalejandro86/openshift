package com.baufest.backend.repository;

import com.baufest.backend.model.SimpleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleBeanRepository extends JpaRepository<SimpleBean, Long> {
}
