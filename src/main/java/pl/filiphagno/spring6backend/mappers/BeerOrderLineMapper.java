package pl.filiphagno.spring6backend.mappers;

import org.mapstruct.Mapper;
import pl.filiphagno.spring6backend.entities.BeerOrderLine;
import pl.filiphagno.spring6backend.model.BeerOrderLineDTO;

@Mapper
public interface BeerOrderLineMapper {

    BeerOrderLineDTO beerOrderLineToBeerOrderLineDTO(BeerOrderLine beerOrderLine);
    BeerOrderLine beerOrderDTOLineToBeerOrderLine(BeerOrderLineDTO beerOrderLine);

}
