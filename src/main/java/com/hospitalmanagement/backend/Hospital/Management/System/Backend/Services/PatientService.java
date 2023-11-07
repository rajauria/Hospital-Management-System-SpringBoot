package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Bill;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.DoctorRepository;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    HospitalService hospitalService;
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    public void addPatientToDB (Patient obj){
        String pID = "Patient" + (patientRepository.getOverallPatients() + 1);
        obj.setpID(pID);
        int bedNumber = hospitalService.getFirstEmptyBed();
        hospitalService.assignPatientToBed(bedNumber,obj);
        Doctor doc = doctorService.getMinimumPatientDoctor();
        patientRepository.assignPatientToDoctor(pID,doc);
        doctorRepository.assignPatientToDoctor(doc.getDocID(),obj);
        patientRepository.addPatientToDB(obj);
    }

    public Doctor getPatientsDoctor (String pID){
        return patientRepository.getPatientsDoctor(pID);
    }

    public Bill dischargePatient (String pID,String dischargeDate){
        Patient obj = patientRepository.getPatientByID(pID);
        String admitDate = obj.getPatientAdmitDate();
        String [] admitDateArray = admitDate.split("-");
        String [] dischargeDateArray = dischargeDate.split("-");
        int diff = Integer.parseInt(dischargeDateArray[0]) - Integer.parseInt(admitDateArray[0]);
        Doctor docObj = patientRepository.getPatientsDoctor(pID);
        int docFees = docObj.getDocFee();
        int bedFees = hospitalService.getBedFee();
        int totalBill = diff * (docFees + bedFees);
        Bill billObj = new Bill(docFees,bedFees,totalBill);
        patientRepository.dischargePatientByID(pID);
        doctorRepository.removeParticularPatientForDoctor(pID,docObj.getDocID());
        hospitalService.deallocatePatientFromBed(pID);
        return billObj;
    }

    public Patient getPatientByID (String pID){
       return patientRepository.getPatientByID(pID);
    }
}
