package com.example.demo.crystobol.repository;


import com.example.demo.crystobol.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

    //@Query("SELECT sr FROM ServiceRequest sr WHERE sr.createdAt BETWEEN :startDate AND :endDate")
    //List<ServiceRequest> findAllByCreatedAtBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
