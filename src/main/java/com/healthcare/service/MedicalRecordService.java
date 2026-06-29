package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.MedicalRecord;
import com.healthcare.model.Patient;
import com.healthcare.repository.MedicalRecordRepository;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;
    @Autowired
    private PatientRepository patientRepository;
    
    public MedicalRecord saveMedicalRecord(MedicalRecord record) {

        Integer patientId = record.getPatient().getPatientId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Patient not found with id : " + patientId));

        record.setPatient(patient);

        return repository.save(record);
    }

    // Get All Medical Records
    public List<MedicalRecord> getAllMedicalRecords() {
        return repository.findAll();
    }

    // Get Medical Record By Id
    public MedicalRecord getMedicalRecordById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Medical Record not found with id : " + id));
    }

    // Update Medical Record
    public MedicalRecord updateMedicalRecord(Integer id, MedicalRecord record) {

        MedicalRecord existing = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Medical Record not found with id : " + id));

        existing.setDiagnosis(record.getDiagnosis());
        existing.setTreatment(record.getTreatment());

        // Update patient if provided
        existing.setPatient(record.getPatient());

        return repository.save(existing);
    }

    // Delete Medical Record
    public String deleteMedicalRecord(Integer id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Medical Record not found with id : " + id);
        }

        repository.deleteById(id);

        return "Medical Record Deleted Successfully";
    }

    // Search By Diagnosis
    public List<MedicalRecord> getMedicalRecordByDiagnosis(String diagnosis) {
        return repository.findByDiagnosis(diagnosis);
    }
}