package com.baufest.app1.repository;

import com.baufest.app1.model.SimpleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleBeanRepository extends JpaRepository<SimpleBean, Long> {
}
