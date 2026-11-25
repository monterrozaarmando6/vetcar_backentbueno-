package com.vetcare.controller;
import com.vetcare.model.Pet; import com.vetcare.repository.PetRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/pets")
public class PetController {
 private final PetRepository repo; public PetController(PetRepository repo){this.repo=repo;}
 @GetMapping public List<Pet> all(){return repo.findAll();}
 @GetMapping("/{id}") public Pet one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
  @GetMapping("/owner/{ownerId}") public List<Pet> byOwner(@PathVariable Long ownerId){return repo.findByOwnerId(ownerId);}

 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Pet create(@Valid @RequestBody Pet value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Pet update(@PathVariable Long id,@Valid @RequestBody Pet value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
