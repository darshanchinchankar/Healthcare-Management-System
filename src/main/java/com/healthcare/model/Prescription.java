package com.healthcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.healthcare.audit.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="prescriptions")

public class Prescription extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer prescriptionId;

    private String medicine;

    private String dosage;

    @JsonIgnoreProperties({"prescription","billing"})
    @OneToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    @Version
    private Integer version;

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

  
}