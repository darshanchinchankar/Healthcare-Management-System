package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.model.Billing;

public interface BillingRepository extends JpaRepository<Billing,Integer>{

    List<Billing> findByPaymentStatus(String status);


    @Query("SELECT SUM(b.amount) FROM Billing b")
    Double totalRevenue();

}