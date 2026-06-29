package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Appointment;
import com.healthcare.model.Billing;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.BillingRepository;

@Service
@Transactional
public class BillingService {

    @Autowired
    private BillingRepository repository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    // Save Billing
    public Billing saveBilling(Billing bill) {

        Integer appointmentId =
                bill.getAppointment().getAppointmentId();

        Appointment appointment =
                appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Appointment not found with id : " + appointmentId));


        bill.setAppointment(appointment);

        return repository.save(bill);
    }


    // Get All
    public List<Billing> getAllBilling() {

        return repository.findAll();
    }


    // Get By Id
    public Billing getBillingById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Billing not found with id : " + id));
    }


    // Update
    public Billing updateBilling(Integer id, Billing bill) {

        Billing existing = getBillingById(id);

        existing.setAmount(bill.getAmount());

        existing.setPaymentStatus(bill.getPaymentStatus());

        return repository.save(existing);
    }


    // Delete
    public String deleteBilling(Integer id) {

        Billing bill = getBillingById(id);

        repository.delete(bill);

        return "Billing Deleted Successfully";
    }


    // Find by Status
    public List<Billing> getBillingByPaymentStatus(String status) {

        return repository.findByPaymentStatus(status);
    }


    // Total Revenue
    public Double totalRevenue() {

        return repository.totalRevenue();
    }

}