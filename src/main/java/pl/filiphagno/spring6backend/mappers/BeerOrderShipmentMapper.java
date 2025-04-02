package pl.filiphagno.spring6backend.mappers;

import org.mapstruct.Mapper;
import pl.filiphagno.spring6backend.entities.BeerOrderShipment;
import pl.filiphagno.spring6backend.model.BeerOrderShipmentDTO;

@Mapper
public interface BeerOrderShipmentMapper {

    BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDTO(BeerOrderShipment beerOrderShipment);
    BeerOrderShipment beerOrderShipmentDTOToBeerOrderShipment(BeerOrderShipmentDTO beerOrderShipment);

}
