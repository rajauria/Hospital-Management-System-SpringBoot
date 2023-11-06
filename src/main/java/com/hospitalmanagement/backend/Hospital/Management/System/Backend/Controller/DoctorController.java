package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/doctor/adddoctor")
    public String addDoctorToDB (@RequestBody Doctor obj){
        doctorService.addDoctorToDB(obj);
        return "Doctor got added successfully into the DB";
    }

    @GetMapping ("/api/doctor")
    public Doctor getDoctorByDocID (@RequestParam String doctorID){
        return doctorService.getDoctorByDocID(doctorID);
    }

    @PutMapping ("/api/doctor")
    public String updateDocDetailsByID (@RequestParam String doctorID, @RequestBody Doctor obj){
        doctorService.updateDocDetailsByID(doctorID,obj);
        return ("Doctor having doc details " + doctorID + " has got their details updated");
    }






}
