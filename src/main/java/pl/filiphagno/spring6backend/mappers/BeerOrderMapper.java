package pl.filiphagno.spring6backend.mappers;

import org.mapstruct.Mapper;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;

@Mapper
public interface BeerOrderMapper {

    BeerOrder beerOrderDTOToBeerOrder(BeerOrderDTO beerOrderDTO);
    BeerOrderDTO beerOrderToBeerOrderDTO(BeerOrder beerOrder);
}
