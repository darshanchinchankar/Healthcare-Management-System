package com.healthcare.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

    List<Appointment> findByStatus(String status);

    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

    @Query("SELECT COUNT(a) FROM Appointment a")
    Long totalAppointments();
}