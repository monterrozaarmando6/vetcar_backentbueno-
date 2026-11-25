package com.vetcare.config;
import com.vetcare.model.*; import com.vetcare.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner demoData(OwnerRepository owners, PetRepository pets, MedicationRepository meds) { return args -> {
 if(owners.count()==0){ Owner o=new Owner(); o.setFullName("Laura Gomez"); o.setEmail("laura.demo@vetcare.com"); o.setPhone("3001234567"); o.setAddress("Pasto"); owners.save(o);
 Pet p=new Pet(); p.setOwnerId(o.getId()); p.setName("Max"); p.setSpecies("Perro"); p.setBreed("Labrador"); p.setSex("Macho"); p.setAge(3); p.setPhysicalCharacteristics("Color café"); pets.save(p);
 }
 if(meds.count()==0){Medication m=new Medication();m.setName("Antiparasitario de prueba");m.setDescription("Registro demostrativo");m.setStock(20);m.setUnitPrice(25000);meds.save(m);}
 }; }
}
