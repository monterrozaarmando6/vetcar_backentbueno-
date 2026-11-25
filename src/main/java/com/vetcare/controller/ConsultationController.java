package com.vetcare.controller;
import com.vetcare.model.Consultation; import com.vetcare.repository.ConsultationRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/consultations")
public class ConsultationController {
 private final ConsultationRepository repo; public ConsultationController(ConsultationRepository repo){this.repo=repo;}
 @GetMapping public List<Consultation> all(){return repo.findAll();}
 @GetMapping("/{id}") public Consultation one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
  @GetMapping("/pet/{petId}") public List<Consultation> byPet(@PathVariable Long petId){return repo.findByPetIdOrderByCreatedAtDesc(petId);}

 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Consultation create(@Valid @RequestBody Consultation value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Consultation update(@PathVariable Long id,@Valid @RequestBody Consultation value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
