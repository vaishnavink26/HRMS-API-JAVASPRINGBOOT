package com.hrms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Table;

@Entity
@Table(name = "outpatients")
public class OutPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    private String email;

    public Object getName() {
        return null;
    }

    public void setName(Object name2) {
    }

    public void setAddress(Class<? extends OutPatient> class1) {
    }

    public Object getPhone() {
        return null;
    }

    public void setPhone(Object phone2) {
    }

    public Object getEmail() {
        return null;
    }

    public void setEmail(Object email2) {
    }

    // getters and setters
}

@Repository
public interface OutPatientRepository extends JpaRepository<OutPatient, Long> {
}

@Service
public class OutPatientService {
    @Autowired
    private OutPatientRepository outPatientRepository;

    public List<OutPatient> getAllOutPatients() {
        return outPatientRepository.findAll();
    }

    public OutPatient getOutPatientById(Long id) {
        return outPatientRepository.findById(id)
                .orElseThrow();
    }

    public OutPatient createOutPatient(OutPatient outPatient) {
        return outPatientRepository.save(outPatient);
    }

    public OutPatient updateOutPatient(Long id, OutPatient outPatientDetails) {
        OutPatient outPatient = outPatientRepository.findById(id)
                .orElseThrow();
        outPatient.setName(outPatientDetails.getName());
        outPatient.setAddress(outPatientDetails.getClass());
        outPatient.setPhone(outPatientDetails.getPhone());
        outPatient.setEmail(outPatientDetails.getEmail());
        OutPatient updatedOutPatient = outPatientRepository.save(outPatient);
        return updatedOutPatient;
    }

    public void deleteOutPatient(Long id) {
        OutPatient outPatient = outPatientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OutPatient", "id", id));
        outPatientRepository.delete(outPatient);
    }
}

@RestController
@RequestMapping("/out_patients")
public class OutPatientController {
    @Autowired
    private OutPatientService outPatientService;

    @GetMapping("")
    public List<OutPatient> getAllOutPatients() {
        return outPatientService.getAllOutPatients();
    }

    @GetMapping("/{id}")
    public OutPatient getOutPatientById(@PathVariable(value = "id") Long id) {
        return outPatientService.getOutPatientById(id);
    }

    @PostMapping("")
    public OutPatient createOutPatient(@Valid @RequestBody OutPatient outPatient) {
        return outPatientService.createOutPatient(outPatient);
    }

    @PutMapping("/{id}")
    public OutPatient updateOutPatient(@PathVariable(value = "id") Long id, @Valid @RequestBody OutPatient outPatientDetails) {
        return outPatientService.updateOutPatient(id, outPatientDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOutPatient(@PathVariable(value = "id") Long id) {
        outPatientService.deleteOutPatient(id);
        return ResponseEntity.ok().build();
    }
}


