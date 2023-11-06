package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public void addPatientToDB (Patient obj){
        String pID = "Patient" + (patientRepository.getOverallPatients() + 1);
        obj.setpID(pID);
        patientRepository.addPatientToDB(obj);
    }

    public void dischargePatient (String pID){
        patientRepository.dischargePatientByID(pID);
    }

    public Patient getPatientByID (String pID){
       return patientRepository.getPatientByID(pID);
    }
}
