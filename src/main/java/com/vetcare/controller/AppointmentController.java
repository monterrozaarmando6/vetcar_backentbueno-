package com.vetcare.controller;
import com.vetcare.model.Appointment; import com.vetcare.repository.AppointmentRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/appointments")
public class AppointmentController {
 private final AppointmentRepository repo; public AppointmentController(AppointmentRepository repo){this.repo=repo;}
 @GetMapping public List<Appointment> all(){return repo.findAll();}
 @GetMapping("/{id}") public Appointment one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
  @GetMapping("/pet/{petId}") public List<Appointment> byPet(@PathVariable Long petId){return repo.findByPetId(petId);}

 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Appointment create(@Valid @RequestBody Appointment value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Appointment update(@PathVariable Long id,@Valid @RequestBody Appointment value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
