package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthcare.model.Billing;
import com.healthcare.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping("/add")
    public ResponseEntity<Billing> addBill(@RequestBody Billing bill) {
        return ResponseEntity.ok(service.saveBilling(bill));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Billing>> getAllBills() {
        return ResponseEntity.ok(service.getAllBilling());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBill(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getBillingById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Billing> updateBill(@PathVariable Integer id,
            @RequestBody Billing bill) {
        return ResponseEntity.ok(service.updateBilling(id, bill));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteBilling(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Billing>> getByPaymentStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.getBillingByPaymentStatus(status));
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> totalRevenue() {
        return ResponseEntity.ok(service.totalRevenue());
    }
}