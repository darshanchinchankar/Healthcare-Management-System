package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

    // Derived Query
    List<Patient> findByCity(String city);

    List<Patient> findByPatientName(String patientName);

    // JPQL Query
    @Query("SELECT p FROM Patient p WHERE p.email=?1")
    Patient findByEmail(String email);

    // Native Query
    @Query(value="SELECT * FROM patients WHERE city=?1",nativeQuery=true)
    List<Patient> getPatientByCity(String city);
}