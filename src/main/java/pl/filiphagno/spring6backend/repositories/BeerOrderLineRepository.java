package pl.filiphagno.spring6backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.filiphagno.spring6backend.entities.BeerOrderLine;

import java.util.UUID;

public interface BeerOrderLineRepository extends JpaRepository<BeerOrderLine, UUID> {
}
