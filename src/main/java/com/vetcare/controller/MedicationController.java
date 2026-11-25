package com.vetcare.controller;
import com.vetcare.model.Medication; import com.vetcare.repository.MedicationRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/medications")
public class MedicationController {
 private final MedicationRepository repo; public MedicationController(MedicationRepository repo){this.repo=repo;}
 @GetMapping public List<Medication> all(){return repo.findAll();}
 @GetMapping("/{id}") public Medication one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Medication create(@Valid @RequestBody Medication value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Medication update(@PathVariable Long id,@Valid @RequestBody Medication value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
