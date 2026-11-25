package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="payments")
public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long ownerId; private Long petId; @NotBlank private String description;
@DecimalMin("0.01") private double amount; @NotBlank private String method;
private String status="PAGADO"; private LocalDateTime paidAt=LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getOwnerId(){return ownerId;} public void setOwnerId(Long v){ownerId=v;}
public Long getPetId(){return petId;} public void setPetId(Long v){petId=v;}
public String getDescription(){return description;} public void setDescription(String v){description=v;}
public double getAmount(){return amount;} public void setAmount(double v){amount=v;}
public String getMethod(){return method;} public void setMethod(String v){method=v;}
public String getStatus(){return status;} public void setStatus(String v){status=v;}
public LocalDateTime getPaidAt(){return paidAt;} public void setPaidAt(LocalDateTime v){paidAt=v;}
}
