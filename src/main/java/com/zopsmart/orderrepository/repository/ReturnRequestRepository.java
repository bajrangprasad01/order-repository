package com.zopsmart.orderrepository.repository;

import com.zopsmart.orderrepository.entity.ReturnRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRequestRepository extends JpaRepository<ReturnRequest, Double> {
}
