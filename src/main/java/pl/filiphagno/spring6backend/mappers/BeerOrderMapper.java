package pl.filiphagno.spring6backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.entities.BeerOrderLine;
import pl.filiphagno.spring6backend.entities.BeerOrderShipment;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;
import pl.filiphagno.spring6backend.model.BeerOrderLineDTO;
import pl.filiphagno.spring6backend.model.BeerOrderShipmentDTO;

@Mapper
public interface BeerOrderMapper {

    BeerOrder beerOrderDTOToBeerOrder(BeerOrderDTO beerOrderDTO);
    BeerOrderDTO beerOrderToBeerOrderDTO(BeerOrder beerOrder);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderShipment beerOrderShipmentDTOToBeerOrderShipment(BeerOrderShipmentDTO beerOrderShipmentDTO);
    BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDTO(BeerOrderShipment beerOrderShipment);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderLine beerOrderLineDTOToBeerOrderLine(BeerOrderLineDTO beerOrderLineDTO);
    BeerOrderLineDTO beerOrderLineToBeerOrderLineDTO(BeerOrderLine beerOrderLine);

}
