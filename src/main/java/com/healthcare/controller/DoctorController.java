package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.healthcare.model.Doctor;
import com.healthcare.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService service;

    // Add Doctor
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(service.saveDoctor(doctor), HttpStatus.CREATED);
    }

    // Get All Doctors
    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(service.getAllDoctors());
    }

    // Get Doctor By Id
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDoctorById(id));
    }

    // Update Doctor
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Integer id,
            @Valid @RequestBody Doctor doctor) {

        return ResponseEntity.ok(service.updateDoctor(id, doctor));
    }

    // Delete Doctor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteDoctor(id));
    }

    // Derived Query
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(
            @PathVariable String specialization) {

    	return ResponseEntity.ok(service.getDoctorBySpecialization(specialization));
    }

    // JPQL Query
    @GetMapping("/hospital/{hospital}")
    public ResponseEntity<List<Doctor>> getDoctorsByHospital(
            @PathVariable String hospital) {

    	return ResponseEntity.ok(service.getDoctorByHospital(hospital));
    }

    // Native Query
    @GetMapping("/native/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorBySpecializationNative(
            @PathVariable String specialization) {

        return ResponseEntity.ok(
                service.getDoctorBySpecializationNative(specialization));
    }
}