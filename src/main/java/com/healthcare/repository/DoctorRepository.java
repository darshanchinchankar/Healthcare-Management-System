package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

    List<Doctor> findBySpecialization(String specialization);

    @Query("SELECT d FROM Doctor d WHERE d.hospital=?1")
    List<Doctor> findByHospital(String hospital);

    @Query(value="SELECT * FROM doctors WHERE specialization=?1",nativeQuery=true)
    List<Doctor> getDoctorBySpecialization(String specialization);
}