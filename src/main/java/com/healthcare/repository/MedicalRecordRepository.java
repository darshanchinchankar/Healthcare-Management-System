package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer>{

    List<MedicalRecord> findByDiagnosis(String diagnosis);

}