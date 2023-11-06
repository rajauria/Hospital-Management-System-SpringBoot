package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap <String, Doctor> doctorDB;
    int overallDoctors;

    public DoctorRepository (){
        this.doctorDB= new HashMap<>();
        this.overallDoctors = 0;
    }

    public void addDoctortoDB (Doctor obj){
        this.overallDoctors += 1;
        doctorDB.put (obj.getDocID(),obj);
    }

    public Doctor getDoctorByID (String docID){
        return doctorDB.get(docID);
    }

    public int getOverallDoctors (){
        return this.overallDoctors;
    }

    public int getTotalDoctors (){
        return this.doctorDB.size();
    }

    public void updateDocDetailsByDocID (String docID, Doctor obj){
        this.doctorDB.put(docID,obj);
    }

}
