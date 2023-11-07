package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap <String, Doctor> doctorDB;
    private HashMap <String, ArrayList<Patient>> docVsPatients;
    int overallDoctors;


    public DoctorRepository (){
        this.doctorDB= new HashMap<>();
        this.overallDoctors = 0;
        this.docVsPatients = new HashMap<>();
    }

    public void addDoctortoDB (Doctor obj){
        this.overallDoctors += 1;
        docVsPatients.put (obj.getDocID(),new ArrayList<>());
        doctorDB.put (obj.getDocID(),obj);
    }

    public void removeParticularPatientForDoctor (String pID, String docID){
        ArrayList<Patient> patients = docVsPatients.get(docID);
        for (int i = 0; i <patients.size();i++){
            Patient obj = patients.get(i);
            if (obj.getpID().equals(pID)){
                patients.remove(i);
                break;
            }
        }
        docVsPatients.put(docID,patients);
    }

    public void assignPatientToDoctor (String docID, Patient obj){
        ArrayList <Patient> patients = this.docVsPatients.get (docID);
        patients.add (obj);
    }


    public HashMap<String, ArrayList<Patient>> getDocVsPatients() {
        return docVsPatients;
    }

    public ArrayList<Patient> getDoctorsPatient  (String docID){
        return docVsPatients.get(docID);
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
