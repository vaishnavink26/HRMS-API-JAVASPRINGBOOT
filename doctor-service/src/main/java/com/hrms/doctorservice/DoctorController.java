package com.hrms.doctorservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    /**
     *
     */
    @Autowired
    private DoctorService doctorService;
    
    // Retrieve a list of all doctors
    @GetMapping("")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    
    // Retrieve a single doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
    
    // Create a new doctor
    @PostMapping("")
    public Doctor createDoctor(@RequestBody Long doctor) {
        return doctorService.createDoctor(doctor);
    }
    
    // Update an existing doctor by ID
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
    
    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.createDoctor(id);
    }
}


