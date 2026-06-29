package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Patient;
import com.healthcare.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
@Validated
public class PatientController {

    @Autowired
    private PatientService service;

    // Add Patient
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {

        Patient savedPatient = service.savePatient(patient);

        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Get All Patients
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {

        return ResponseEntity.ok(service.getAllPatients());
    }

    // Get Patient By Id
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) {

        Patient patient = service.getPatientById(id);

        if(patient!=null)
            return ResponseEntity.ok(patient);

        return ResponseEntity.notFound().build();
    }

    // Update Patient
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Integer id,
            @Valid @RequestBody Patient patient){

        Patient updated = service.updatePatient(id, patient);

        if(updated!=null)
            return ResponseEntity.ok(updated);

        return ResponseEntity.notFound().build();
    }

    // Delete Patient
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id){

        return ResponseEntity.ok(service.deletePatient(id));
    }

    // Find By City
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Patient>> getPatientByCity(@PathVariable String city){

        return ResponseEntity.ok(service.getPatientByCity(city));
    }

    // Find By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Patient>> getPatientByName(@PathVariable String name){

        return ResponseEntity.ok(service.getPatientByName(name));
    }

    // JPQL Query
    @GetMapping("/email/{email}")
    public ResponseEntity<Patient> getPatientByEmail(@PathVariable String email){

        return ResponseEntity.ok(service.getPatientByEmail(email));
    }

 // Native Query
    @GetMapping("/native/{city}")
    public ResponseEntity<List<Patient>> getNativePatientByCity(@PathVariable String city) {

        return ResponseEntity.ok(service.getNativePatientByCity(city));
    }

}