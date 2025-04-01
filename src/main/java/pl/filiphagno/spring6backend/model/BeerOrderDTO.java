package pl.filiphagno.spring6backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import pl.filiphagno.spring6backend.entities.BeerOrderLine;
import pl.filiphagno.spring6backend.entities.BeerOrderShipment;
import pl.filiphagno.spring6backend.entities.Customer;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class BeerOrderDTO {

    private UUID id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    public boolean isNew() {
        return this.id == null;
    }

    private String customerRef;

    private Customer customer;

    private Set<BeerOrderLine> beerOrderLines;

    private BeerOrderShipment beerOrderShipment;
}
