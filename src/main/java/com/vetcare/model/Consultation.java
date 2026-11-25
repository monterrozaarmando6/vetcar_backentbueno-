package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="consultations")
public class Consultation {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long petId; @NotBlank private String veterinarian; @NotBlank private String symptoms;
@NotBlank private String diagnosis; private String treatment; private String observations;
private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getPetId(){return petId;} public void setPetId(Long v){petId=v;}
public String getVeterinarian(){return veterinarian;} public void setVeterinarian(String v){veterinarian=v;}
public String getSymptoms(){return symptoms;} public void setSymptoms(String v){symptoms=v;}
public String getDiagnosis(){return diagnosis;} public void setDiagnosis(String v){diagnosis=v;}
public String getTreatment(){return treatment;} public void setTreatment(String v){treatment=v;}
public String getObservations(){return observations;} public void setObservations(String v){observations=v;}
public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
