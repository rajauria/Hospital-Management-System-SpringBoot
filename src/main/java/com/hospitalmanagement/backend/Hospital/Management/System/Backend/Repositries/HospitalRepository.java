package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {
    private Patient[] beds;
    public HospitalRepository (){
        this.beds = new Patient[500];
    }

    public void assignPatientToBed(int bedNumber,Patient obj){
        beds[bedNumber] = obj;
    }

    public Patient[] getBeds() {
        return beds;
    }

    public Patient getPatientAtParticularBed (int bedNumber){
        return beds[bedNumber];
    }
}
