package pl.filiphagno.spring6backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.filiphagno.spring6backend.entities.BeerAudit;

import java.util.UUID;

public interface BeerAuditRepository extends JpaRepository<BeerAudit, UUID> {
}
