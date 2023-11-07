package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class PatientRepository {
    private HashMap <String, Patient> patientDB;

    private HashMap <String, Doctor> patientVsDoctor;
    private int overallPatients ;

    public PatientRepository (){
        this.patientDB = new HashMap<>();
        this.overallPatients = 0;
        this.patientVsDoctor = new HashMap<>();
    }

    public void assignPatientToDoctor (String pID, Doctor obj){
        this.patientVsDoctor.put (pID,obj);
    }

    public Patient getPatientByID (String patientID){
        return this.patientDB.get (patientID);
    }

    public void addPatientToDB (Patient obj){
        this.patientDB.put (obj.getpID(),obj);
        this.overallPatients += 1;
    }

    public Doctor getPatientsDoctor (String pID){
        return this.patientVsDoctor.get(pID);
    }

    public void dischargePatientByID (String patientID){
        this.patientDB.remove(patientID);
        this.patientVsDoctor.remove(patientID);
    }

    public int totalPatients (){
        return this.patientDB.size ();
    }

    public int getOverallPatients (){
        return this.overallPatients ;
    }



}
