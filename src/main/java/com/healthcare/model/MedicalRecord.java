package com.healthcare.model;

import com.healthcare.audit.BaseEntity;

import jakarta.persistence.*;

@Entity
@Table(name="medical_records")

public class MedicalRecord extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer recordId;

    private String diagnosis;

    private String treatment;

    @ManyToOne
    @JoinColumn(name="patient_id")

    private Patient patient;

    @Version
    private Integer version;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

   
}