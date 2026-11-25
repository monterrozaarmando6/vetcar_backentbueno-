package com.vetcare.controller;
import com.vetcare.model.Owner; import com.vetcare.repository.OwnerRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/owners")
public class OwnerController {
 private final OwnerRepository repo; public OwnerController(OwnerRepository repo){this.repo=repo;}
 @GetMapping public List<Owner> all(){return repo.findAll();}
 @GetMapping("/{id}") public Owner one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Owner create(@Valid @RequestBody Owner value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Owner update(@PathVariable Long id,@Valid @RequestBody Owner value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
