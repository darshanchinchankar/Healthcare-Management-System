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
@Table(name="billing")

public class Billing extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer billId;

    private Double amount;

    private String paymentStatus;
    @OneToOne
    @JoinColumn(name="appointment_id")
    @JsonIgnoreProperties("billing")
    private Appointment appointment;

    @Version
    private Integer version;

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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