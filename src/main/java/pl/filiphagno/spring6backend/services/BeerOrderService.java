package pl.filiphagno.spring6backend.services;

import org.springframework.data.domain.Page;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.model.BeerOrderCreateDTO;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;
import pl.filiphagno.spring6backend.model.BeerOrderUpdateDTO;

import java.util.Optional;
import java.util.UUID;

public interface BeerOrderService {
    Page<BeerOrderDTO> getBeerOrders(Integer pageNumber, Integer pageSize);
    Optional<BeerOrderDTO> getBeerOrderById(UUID beerOrderId);
    BeerOrderDTO updateBeerOrderById(UUID beerOrderId, BeerOrderUpdateDTO beerOrderUpdateDTO);
    BeerOrder createBeerOrder(BeerOrderCreateDTO beerOrderCreateDTO);

    Boolean deleteBeerOrderById(UUID beerOrderId);
}
