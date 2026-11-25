package com.vetcare.repository;
import com.vetcare.model.Consultation; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
 List<Consultation> findByPetIdOrderByCreatedAtDesc(Long petId);
}
