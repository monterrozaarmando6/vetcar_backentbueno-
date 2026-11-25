package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="appointments")
public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long petId; @NotNull private Long ownerId; @NotBlank private String veterinarian;
@NotNull private LocalDateTime dateTime; private String reason; private String status="PROGRAMADA";
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getPetId(){return petId;} public void setPetId(Long v){petId=v;}
public Long getOwnerId(){return ownerId;} public void setOwnerId(Long v){ownerId=v;}
public String getVeterinarian(){return veterinarian;} public void setVeterinarian(String v){veterinarian=v;}
public LocalDateTime getDateTime(){return dateTime;} public void setDateTime(LocalDateTime v){dateTime=v;}
public String getReason(){return reason;} public void setReason(String v){reason=v;}
public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
