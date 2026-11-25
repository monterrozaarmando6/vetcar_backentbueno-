package com.vetcare.repository;
import com.vetcare.model.Appointment; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
 List<Appointment> findByPetId(Long petId);
}
