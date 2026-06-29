package com.healthcare.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthcare.model.Appointment;
import com.healthcare.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.saveAppointment(appointment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(service.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getAppointmentById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id,
            @RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.updateAppointment(id, appointment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteAppointment(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.getAppointmentByStatus(status));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Appointment>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(service.getAppointmentByDate(date));
    }
}