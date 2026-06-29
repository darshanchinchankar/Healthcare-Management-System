package com.healthcare.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.healthcare.audit.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="appointments")

public class Appointment extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer appointmentId;

    private LocalDate appointmentDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"appointments", "records"})
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties("appointments")
    private Doctor doctor;

    @OneToOne(mappedBy="appointment", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("appointment")
    private Prescription prescription;


    @OneToOne(mappedBy="appointment", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("appointment")
    private Billing billing;

    @Version
    private Integer version;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

   
}