package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository repository;

    // Save Patient
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    // Get All Patients
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    // Get Patient By Id
    public Patient getPatientById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Patient not found with Id : " + id));
    }

    // Update Patient
    public Patient updatePatient(Integer id, Patient patient) {

        Patient existing = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Patient not found with Id : " + id));

        existing.setPatientName(patient.getPatientName());
        existing.setEmail(patient.getEmail());
        existing.setMobile(patient.getMobile());
        existing.setGender(patient.getGender());
        existing.setAddress(patient.getAddress());
        existing.setCity(patient.getCity());

        return repository.save(existing);
    }

    // Delete Patient
    public String deletePatient(Integer id) {

        Patient patient = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Patient not found with Id : " + id));

        repository.delete(patient);

        return "Patient Deleted Successfully";
    }

    // Derived Query
    public List<Patient> getPatientByCity(String city) {
        return repository.findByCity(city);
    }

    // Derived Query
    public List<Patient> getPatientByName(String patientName) {
        return repository.findByPatientName(patientName);
    }

    // JPQL Query
    public Patient getPatientByEmail(String email) {
        return repository.findByEmail(email);
    }

 // Native Query
    public List<Patient> getNativePatientByCity(String city) {
        return repository.getPatientByCity(city);
    }
}