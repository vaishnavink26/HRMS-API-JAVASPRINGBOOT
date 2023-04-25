package com.hrms;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InPatientController {

    private final InPatientRepository inPatientRepository;

    public InPatientController(InPatientRepository inPatientRepository) {
        this.inPatientRepository = inPatientRepository;
    }

    // Retrieve a list of all inpatients
    @GetMapping("/in_patients")
    public List<InPatient> getAllInPatients() {
        return inPatientRepository.findAll();
    }

    // Retrieve a single inpatient by ID
    @GetMapping("/in_patients/{in_patient_id}")
    public ResponseEntity<InPatient> getInPatientById(@PathVariable(value = "in_patient_id") Long id) {
        InPatient inPatient = ((Object) inPatientRepository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("InPatient", "id", id));
        return ResponseEntity.ok().body(inPatient);
    }

    // Create a new inpatient
    @PostMapping("/in_patients")
    public InPatient createInPatient(@Valid @RequestBody InPatient inPatient) {
        return inPatientRepository.save(inPatient);
    }

    // Update an existing inpatient by ID
    @PutMapping("/in_patients/{in_patient_id}")
    public ResponseEntity<InPatient> updateInPatient(@PathVariable(value = "in_patient_id") Long id,
                                                      @Valid @RequestBody InPatient inPatientDetails) {
        InPatient inPatient = ((Object) inPatientRepository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("InPatient", "id", id));

        inPatient.setName(inPatientDetails.getName());
        inPatient.setGender(inPatientDetails.getGender());
        inPatient.setName(inPatientDetails.getName());
        // set other fields that need to be updated

        final InPatient updatedInPatient = inPatientRepository.save(inPatient);
        return ResponseEntity.ok(updatedInPatient);
    }

    // Delete an inpatient by ID
    @DeleteMapping("/in_patients/{in_patient_id}")
    public ResponseEntity<?> deleteInPatient(@PathVariable(value = "in_patient_id") Long id) {
        InPatient inPatient = ((Object) inPatientRepository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("InPatient", "id", id));
        inPatientRepository.delete(inPatient);
        return ResponseEntity.ok().build();
    }
}
