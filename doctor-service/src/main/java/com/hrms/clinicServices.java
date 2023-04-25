package com.hrms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

public class clinicServices {
    
}


public class Clinic {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    public Clinic() {
    }

    public Clinic(Long id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Object getId() {
        return null;
    }

    public Object getName() {
        return null;
    }

    public void setName(Object name2) {
    }

    public Object getAddress() {
        return null;
    }

    public Object getPhoneNumber() {
        return null;
    }

    public void setPhoneNumber(Object phoneNumber2) {
    }

    public void setAddress(Object address2) {
    }

    // getters and setters
}


@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private List<Clinic> clinics = new ArrayList<>();

    // GET /clinics - Returns a list of all clinics
    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinics;
    }

    // GET /clinics/{clinic_id} - Returns the details of a specific clinic
    @GetMapping("/{id}")
    public Clinic getClinicById(@PathVariable Long id) {
        // Find clinic by id in clinics list
        return clinics.stream()
                .filter(clinic -> clinic.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinic not found"));
    }

    // POST /clinics - Creates a new clinic
    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) {
        // Generate new id for clinic
        Long id = clinics.size() + 1L;
        clinic.setId(id);
        clinics.add(clinic);
        return clinic;
    }

    // PUT /clinics/{clinic_id} - Updates the details of a specific clinic
    @PutMapping("/{id}")
    public Clinic updateClinic(@PathVariable Long id, @RequestBody Clinic clinic) {
        Clinic existingClinic = getClinicById(id);
        existingClinic.setName(clinic.getName());
        existingClinic.setAddress(clinic.getAddress());
        existingClinic.setPhoneNumber(clinic.getPhoneNumber());
        return existingClinic;
    }

    // DELETE /clinics/{clinic_id} - Deletes a specific clinic
    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        Clinic clinic = getClinicById(id);
        clinics.remove(clinic);
    }
}



