package pl.filiphagno.spring6backend.model;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
public class BeerOrderLineUpdateDTO {

    private UUID id;

    @NotNull
    private UUID beerId;

    @Min(value = 1, message = "Quantity On Hand must be greater than 0")
    private Integer orderQuantity;

    private Integer quantityAllocated;
}
