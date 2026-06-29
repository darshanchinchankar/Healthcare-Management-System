package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthcare.model.Prescription;
import com.healthcare.service.PrescriptionService;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    @PostMapping("/add")
    public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription) {
        return ResponseEntity.ok(service.savePrescription(prescription));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(service.getAllPrescriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPrescriptionById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Integer id,
            @RequestBody Prescription prescription) {
        return ResponseEntity.ok(service.updatePrescription(id, prescription));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deletePrescription(id));
    }

    @GetMapping("/medicine/{medicine}")
    public ResponseEntity<List<Prescription>> getByMedicine(@PathVariable String medicine) {
        return ResponseEntity.ok(service.getPrescriptionByMedicine(medicine));
    }
}