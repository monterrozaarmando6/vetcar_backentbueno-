package com.vetcare.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.*;
@Entity @Table(name="pets")
public class Pet {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long ownerId;
@NotBlank @Column(nullable=false) private String name;
@NotBlank @Column(nullable=false) private String species;
private String breed; private String sex; @Min(0) private Integer age; private String physicalCharacteristics;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getOwnerId(){return ownerId;} public void setOwnerId(Long v){ownerId=v;}
public String getName(){return name;} public void setName(String v){name=v;}
public String getSpecies(){return species;} public void setSpecies(String v){species=v;}
public String getBreed(){return breed;} public void setBreed(String v){breed=v;}
public String getSex(){return sex;} public void setSex(String v){sex=v;}
public Integer getAge(){return age;} public void setAge(Integer v){age=v;}
public String getPhysicalCharacteristics(){return physicalCharacteristics;} public void setPhysicalCharacteristics(String v){physicalCharacteristics=v;}
}
