package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository ;

    public void addDoctorToDB (Doctor obj){
        String docID = "Doctor" + (doctorRepository.getOverallDoctors() + 1);
        obj.setDocID(docID);
        doctorRepository.addDoctortoDB(obj);
    }

    public Doctor getDoctorByDocID (String docID){
        return doctorRepository.getDoctorByID(docID);
    }

    public void updateDocDetailsByID (String docID, Doctor obj){
        doctorRepository.updateDocDetailsByDocID(docID,obj);
    }

}
