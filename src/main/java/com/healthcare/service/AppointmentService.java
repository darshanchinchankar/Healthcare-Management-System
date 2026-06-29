package com.healthcare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Appointment;
import com.healthcare.model.Doctor;
import com.healthcare.model.Patient;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment saveAppointment(Appointment appointment) {

        Integer patientId = appointment.getPatient().getPatientId();
        Integer doctorId = appointment.getDoctor().getDoctorId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return repository.save(appointment);
    }
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Appointment getAppointmentById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id : " + id));
    }

    public Appointment updateAppointment(Integer id, Appointment appointment) {

        Appointment existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id : " + id));

        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setStatus(appointment.getStatus());

        return repository.save(existing);
    }

    public String deleteAppointment(Integer id) {

        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Appointment not found with id : " + id);

        repository.deleteById(id);

        return "Appointment Deleted Successfully";
    }

    public List<Appointment> getAppointmentByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Appointment> getAppointmentByDate(LocalDate date) {
        return repository.findByAppointmentDate(date);
    }

}