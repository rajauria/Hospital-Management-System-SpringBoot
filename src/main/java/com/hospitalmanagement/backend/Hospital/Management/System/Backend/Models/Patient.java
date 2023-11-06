package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models;

public class Patient {
    private String pID;
    private String patientName;

    private String patientGender;

    private int patientAge;
    private String patientAddress;
    private String patientDisease;

    public Patient(String pID, String patientName, String patientGender, int patientAge, String patientAddress, String patientDisease) {
        this.pID = pID;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
        this.patientDisease = patientDisease;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }
}