package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="owners")
public class Owner {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String fullName;
@NotBlank @Email @Column(nullable=false, unique=true) private String email;
@NotBlank @Column(nullable=false) private String phone;
private String address;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
public String getEmail(){return email;} public void setEmail(String v){email=v;}
public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
public String getAddress(){return address;} public void setAddress(String v){address=v;}
}
