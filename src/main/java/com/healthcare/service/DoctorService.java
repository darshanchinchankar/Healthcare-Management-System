package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctorById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Doctor not found with id : " + id));
    }

    public Doctor updateDoctor(Integer id, Doctor doctor) {

        Doctor existing = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Doctor not found with id : " + id));

        existing.setDoctorName(doctor.getDoctorName());
        existing.setSpecialization(doctor.getSpecialization());
        existing.setHospital(doctor.getHospital());

        return repository.save(existing);
    }

    public String deleteDoctor(Integer id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id : " + id);
        }

        repository.deleteById(id);

        return "Doctor Deleted Successfully";
    }

    public List<Doctor> getDoctorBySpecialization(String specialization) {
        return repository.findBySpecialization(specialization);
    }

    public List<Doctor> getDoctorByHospital(String hospital) {
        return repository.findByHospital(hospital);
    }

    public List<Doctor> getDoctorBySpecializationNative(String specialization) {
        return repository.getDoctorBySpecialization(specialization);
    }
}