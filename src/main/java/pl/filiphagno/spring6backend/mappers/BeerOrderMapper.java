package pl.filiphagno.spring6backend.mappers;

import guru.springframework.spring6restmvcapi.model.BeerOrderDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderLineDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderShipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.entities.BeerOrderLine;
import pl.filiphagno.spring6backend.entities.BeerOrderShipment;

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
