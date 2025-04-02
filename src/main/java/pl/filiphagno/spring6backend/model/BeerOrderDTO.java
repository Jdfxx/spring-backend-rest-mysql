package pl.filiphagno.spring6backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

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

    private String customerRef;

    @NotNull
    @NotBlank
    private CustomerDTO customerDTO;

    private Set<BeerOrderLineDTO> beerOrderLines;

    private BeerOrderShipmentDTO beerOrderShipment;
}
