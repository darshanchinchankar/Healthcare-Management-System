package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthcare.model.MedicalRecord;
import com.healthcare.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalrecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @PostMapping("/add")
    public ResponseEntity<MedicalRecord> addRecord(@RequestBody MedicalRecord record) {
        return ResponseEntity.ok(service.saveMedicalRecord(record));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicalRecord>> getAllRecords() {
        return ResponseEntity.ok(service.getAllMedicalRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getRecord(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getMedicalRecordById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalRecord> updateRecord(@PathVariable Integer id,
            @RequestBody MedicalRecord record) {
        return ResponseEntity.ok(service.updateMedicalRecord(id, record));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteMedicalRecord(id));
    }

    @GetMapping("/diagnosis/{diagnosis}")
    public ResponseEntity<List<MedicalRecord>> getByDiagnosis(@PathVariable String diagnosis) {
        return ResponseEntity.ok(service.getMedicalRecordByDiagnosis(diagnosis));
    }
}