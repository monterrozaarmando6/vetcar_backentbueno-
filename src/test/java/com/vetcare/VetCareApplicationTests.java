package com.vetcare;
import com.vetcare.model.Owner; import com.vetcare.repository.OwnerRepository;
import org.junit.jupiter.api.Test; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest class VetCareApplicationTests {
 @Autowired OwnerRepository owners;
 @Test void savesAndReadsOwner(){ Owner o=new Owner(); o.setFullName("Prueba Automatizada");o.setEmail("test"+System.nanoTime()+"@example.com");o.setPhone("3000000000"); Owner saved=owners.save(o); assertThat(owners.findById(saved.getId())).isPresent(); }
}
