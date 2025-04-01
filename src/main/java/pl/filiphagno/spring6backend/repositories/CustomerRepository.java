package pl.filiphagno.spring6backend.repositories;

import pl.filiphagno.spring6backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
