package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.DoctorRepository;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    public void addPatientToDB (Patient obj){
        String pID = "Patient" + (patientRepository.getOverallPatients() + 1);
        obj.setpID(pID);
        Doctor doc = doctorService.getMinimumPatientDoctor();
        patientRepository.assignPatientToDoctor(pID,doc);
        doctorRepository.assignPatientToDoctor(doc.getDocID(),obj);
        patientRepository.addPatientToDB(obj);
    }

    public Doctor getPatientsDoctor (String pID){
        return patientRepository.getPatientsDoctor(pID);
    }

    public void dischargePatient (String pID){
        patientRepository.dischargePatientByID(pID);
    }

    public Patient getPatientByID (String pID){
       return patientRepository.getPatientByID(pID);
    }
}
