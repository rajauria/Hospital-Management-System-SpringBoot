package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository ;

    public void addDoctorToDB (Doctor obj){
        String docID = "Doctor" + (doctorRepository.getOverallDoctors() + 1);
        obj.setDocID(docID);
        doctorRepository.addDoctortoDB(obj);
    }

    public Doctor getMinimumPatientDoctor (){
        int min = Integer.MAX_VALUE;
        HashMap <String, ArrayList< Patient>> docVsPatientsDB = doctorRepository.getDocVsPatients();
        Doctor obj = null;
        for (String key : docVsPatientsDB.keySet()){
            ArrayList<Patient> doctorsPatient = docVsPatientsDB.get(key);
            int totalPatients = doctorsPatient.size();
            if (totalPatients < min){
                min = totalPatients;
                obj = doctorRepository.getDoctorByID(key);
            }
        }
        return obj;
    }

    public ArrayList<Patient> getDoctorsPatient (String docID){
        return doctorRepository.getDoctorsPatient(docID);
    }
    public void removeParticularPatient (String pID, String docID){
        doctorRepository.removeParticularPatientForDoctor(pID,docID);
    }

    public Doctor getDoctorByDocID (String docID){
        return doctorRepository.getDoctorByID(docID);
    }

    public void updateDocDetailsByID (String docID, Doctor obj){
        doctorRepository.updateDocDetailsByDocID(docID,obj);
    }

}
