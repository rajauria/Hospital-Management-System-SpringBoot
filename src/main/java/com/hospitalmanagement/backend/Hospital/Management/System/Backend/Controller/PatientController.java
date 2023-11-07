package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping ("/api/patient")
    public Patient getPatientByID (@RequestParam String patientID){
       return patientService.getPatientByID(patientID);
    }

    @PostMapping ("/api/patient/addpatient")
    public String addPatientToDB (@RequestBody Patient obj){
        patientService.addPatientToDB(obj);
        return "Patient got add successfully into DB";
    }

    @DeleteMapping ("/api/patient/deletepatient")
    public String deletePatientByID (@RequestParam String patientID){
        patientService.dischargePatient(patientID);
        return "Patient got discharged having patient ID - " + patientID;
    }

    @GetMapping ("/api/patient/getdoctor/{pID}")
    public Doctor getPatientsDoctor (@PathVariable String pID){
        return patientService.getPatientsDoctor(pID);
    }




}
