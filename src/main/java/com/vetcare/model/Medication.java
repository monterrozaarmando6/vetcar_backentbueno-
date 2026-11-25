package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="medications")
public class Medication {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; private String description; @Min(0) private int stock;
@DecimalMin("0.0") private double unitPrice; private LocalDate expirationDate;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
public String getDescription(){return description;} public void setDescription(String v){description=v;}
public int getStock(){return stock;} public void setStock(int v){stock=v;}
public double getUnitPrice(){return unitPrice;} public void setUnitPrice(double v){unitPrice=v;}
public LocalDate getExpirationDate(){return expirationDate;} public void setExpirationDate(LocalDate v){expirationDate=v;}
}
