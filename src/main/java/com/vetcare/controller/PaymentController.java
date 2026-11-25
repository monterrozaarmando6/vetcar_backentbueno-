package com.vetcare.controller;
import com.vetcare.model.Payment; import com.vetcare.repository.PaymentRepository; import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/payments")
public class PaymentController {
 private final PaymentRepository repo; public PaymentController(PaymentRepository repo){this.repo=repo;}
 @GetMapping public List<Payment> all(){return repo.findAll();}
 @GetMapping("/{id}") public Payment one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Payment create(@Valid @RequestBody Payment value){value.setId(null); return repo.save(value);}
 @PutMapping("/{id}") public Payment update(@PathVariable Long id,@Valid @RequestBody Payment value){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"); value.setId(id);return repo.save(value);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado");repo.deleteById(id);}
}
