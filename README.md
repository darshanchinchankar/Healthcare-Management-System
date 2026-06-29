Healthcare Management System

Project Description
Healthcare Management System is a REST API developed using Spring Boot, Spring Data JPA, Hibernate, and MySQL.

The system manages:
* Patients
* Doctors
* Appointments
* Prescriptions
* Medical Records
* Billing

Technologies Used
* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman

Modules
1. Patient Management
2. Doctor Management
3. Appointment Management
4. Prescription Management
5. Medical Record Management
6. Billing Management

 Features
* CRUD Operations
* Validation
* Exception Handling
* Derived Queries
* JPQL Queries
* Native Queries
* Audit Fields
- Optimistic Locking

Database
MySQL
Database Name: healthcaredb

Author:Darshan Suryakant chinchankar



Database Schema (ER Diagram)

PATIENT
patient_id (PK)
patient_name
email
mobile
gender
address
city
Relation
One Patient To Many
APPOINTMENT
appointment_id (PK)
appointment_date
status
patient_id (FK)
doctor_id (FK)
Relation
One To One

PRESCRIPTION
prescription_id (PK)
medicine
dosage
appointment_id (FK)
Relation
 One To One
BILLING
billing_id (PK)
amount
payment_status
appointment_id (FK)

DOCTOR
doctor_id (PK)
doctor_name
specialization
hospital

PATIENT
Relation
One To Many

MEDICAL_RECORD
record_id (PK)
diagnosis
treatment
patient_id (FK)
Relation
One To Many

Project Structure

Com.Healthcare
Controller
Service
Repository
Model
Exception
Audit
Dto
Config
 
 
 
Healthcare Management System REST APIs
Patient APIs
•	POST /patient/add – Add a new patient.
•	GET /patient/all – Retrieve all patients.
•	GET /patient/{id} – Retrieve a patient by ID.
•	PUT /patient/update/{id} – Update patient details.
•	DELETE /patient/delete/{id} – Delete a patient.
•	GET /patient/city/{city} – Find patients by city.
•	GET /patient/name/{name} – Find patients by name.
•	GET /patient/email/{email} – Find a patient by email (JPQL Query)
•	GET /patient/native/{city} – Find patients by city (Native Query)

Doctor APIs
•	POST /doctor/add – Add a new doctor.
•	GET /doctor/all – Retrieve all doctors.
•	GET /doctor/{id} – Retrieve a doctor by ID.
•	PUT /doctor/update/{id} – Update doctor details.
•	DELETE /doctor/delete/{id} – Delete a doctor.
•	GET /doctor/specialization/{specialization} – Find doctors by specialization.
•	GET /doctor/hospital/{hospital} – Find doctors by hospital (JPQL Query).
•	GET /doctor/native/{specialization} – Find doctors by specialization (Native Query).

Appointment APIs
•	POST /appointment/add – Schedule a new appointment.
•	GET /appointment/all – Retrieve all appointments.
•	GET /appointment/{id} – Retrieve an appointment by ID.
•	PUT /appointment/update/{id} – Update appointment details.
•	DELETE /appointment/delete/{id} – Delete an appointment.
•	GET /appointment/status/{status} – Find appointments by status.
•	GET /appointment/date/{date} – Find appointments by date.
•	GET /appointment/native/{status} – Find appointments by status (Native Query).

Prescription APIs
•	POST /prescription/add – Add a new prescription.
•	GET /prescription/all – Retrieve all prescriptions.
•	GET /prescription/{id} – Retrieve a prescription by ID.
•	PUT /prescription/update/{id} – Update prescription details.
•	DELETE /prescription/delete/{id} – Delete a prescription.
•	GET /prescription/medicine/{medicine} – Find prescriptions by medicine.
•	GET /prescription/dosage/{dosage} – Find prescriptions by dosage.
•	GET /prescription/native/{medicine} – Find prescriptions by medicine (Native Query).

Medical Record APIs
•	POST/medicalrecord/add – Add a new medical record.
•	GET /medicalrecord/all – Retrieve all medical records.
•	GET /medicalrecord/{id} – Retrieve a medical record by ID.
•	PUT /medicalrecord/update/{id} – Update a medical record.
•	DELETE /medicalrecord/delete/{id} – Delete a medical record.
•	GET /medicalrecord/diagnosis/{diagnosis} – Find medical records by diagnosis.
•	GET /medicalrecord/patient/{id} – Find medical records by patient ID.
•	GET /medicalrecord/native/{diagnosis} – Find medical records by diagnosis (Native Query).

Billing APIs
•	POST /billing/add – Add a new billing record.
•	GET /billing/all – Retrieve all billing records.
•	GET /billing/{id} – Retrieve a billing record by ID.
•	PUT /billing/update/{id} – Update billing details.
•	DELETE /billing/delete/{id} – Delete a billing record.
•	GET /billing/status/{paymentStatus} – Find billing records by payment status.
•	GET /billing/amount/{amount} – Find billing records by amount.
•	GET /billing/native/{paymentStatus} – Find billing records by payment status (Native Query).

Swagger UI
http://localhost:8080/swagger-ui/index.html
 
Actuator
http://localhost:8080/actuator
 