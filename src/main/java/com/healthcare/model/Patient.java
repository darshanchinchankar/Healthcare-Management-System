package com.healthcare.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthcare.audit.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "patients")

@NamedQuery(
    name = "Patient.findByCity",
    query = "SELECT p FROM Patient p WHERE p.city = ?1"
)
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @NotBlank(message = "Patient Name is Required")
    private String patientName;

    @Email(message = "Enter Valid Email")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
    @Column(unique = true)
    private String mobile;

    @NotBlank(message = "Gender is Required")
    private String gender;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotBlank(message = "City is Required")
    private String city;

    @Version
    private Integer version;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> records;

    // Default Constructor
    public Patient() {
    }

    // Parameterized Constructor
    public Patient(Integer patientId, String patientName, String email, String mobile,
                   String gender, String address, String city, Integer version,
                   List<Appointment> appointments, List<MedicalRecord> records) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.version = version;
        this.appointments = appointments;
        this.records = records;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<MedicalRecord> getRecords() {
        return records;
    }

    public void setRecords(List<MedicalRecord> records) {
        this.records = records;
    }
}