package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    // Derived Query
    List<Prescription> findByMedicine(String medicine);

    // JPQL Query
    @Query("SELECT p FROM Prescription p WHERE p.dosage = ?1")
    List<Prescription> findByDosage(String dosage);

    // Native Query
    @Query(value = "SELECT * FROM prescriptions WHERE medicine = ?1", nativeQuery = true)
    List<Prescription> getPrescriptionByMedicine(String medicine);
}