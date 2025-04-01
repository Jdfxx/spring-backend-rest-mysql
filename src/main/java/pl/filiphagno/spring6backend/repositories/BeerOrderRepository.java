package pl.filiphagno.spring6backend.repositories;

import pl.filiphagno.spring6backend.entities.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
}
