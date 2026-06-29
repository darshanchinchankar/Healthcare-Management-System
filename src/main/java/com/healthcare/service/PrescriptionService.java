package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Appointment;
import com.healthcare.model.Prescription;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.PrescriptionRepository;

@Service
@Transactional
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    // Save Prescription
    public Prescription savePrescription(Prescription prescription) {

        Integer appointmentId = prescription.getAppointment()
                                           .getAppointmentId();

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Appointment not found with id : " + appointmentId));

        prescription.setAppointment(appointment);

        return repository.save(prescription);
    }


    // Get All Prescriptions
    public List<Prescription> getAllPrescriptions() {

        return repository.findAll();
    }


    // Get Prescription By Id
    public Prescription getPrescriptionById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Prescription not found with id : " + id));
    }


    // Update Prescription
    public Prescription updatePrescription(Integer id, Prescription prescription) {

        Prescription existing = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Prescription not found with id : " + id));


        existing.setMedicine(prescription.getMedicine());

        existing.setDosage(prescription.getDosage());


        return repository.save(existing);
    }


    // Delete Prescription
    public String deletePrescription(Integer id) {

        Prescription prescription = repository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException(
                "Prescription not found with id : " + id));


        repository.delete(prescription);


        return "Prescription Deleted Successfully";
    }


    // Derived Query
    public List<Prescription> getPrescriptionByMedicine(String medicine) {

        return repository.findByMedicine(medicine);
    }


    // JPQL Query
    public List<Prescription> getPrescriptionByDosage(String dosage) {

        return repository.findByDosage(dosage);
    }


    // Native Query
    public List<Prescription> getPrescriptionByMedicineNative(String medicine) {

        return repository.getPrescriptionByMedicine(medicine);
    }
}