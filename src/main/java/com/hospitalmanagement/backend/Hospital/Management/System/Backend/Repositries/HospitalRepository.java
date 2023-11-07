
package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositries;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {
    private Patient[] beds;

    private final int bedFee = 500;
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

    public int getBedFee() {
        return bedFee;
    }

    public void deallocatePatientFromBed (String pID){
        for (int i = 0; i < beds.length; i++){
            if (beds[i] != null){
                Patient obj = beds[i];
                if (obj.getpID() == pID){
                    beds[i] = null;
                    break;
                }
            }
        }
    }
}

