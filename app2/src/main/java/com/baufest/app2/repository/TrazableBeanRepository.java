package com.baufest.app2.repository;

import com.baufest.app2.model.TrazableBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrazableBeanRepository extends JpaRepository<TrazableBean, Long> {
}
