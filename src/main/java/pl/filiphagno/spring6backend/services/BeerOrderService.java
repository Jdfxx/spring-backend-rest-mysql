package pl.filiphagno.spring6backend.services;

import guru.springframework.spring6restmvcapi.model.BeerOrderCreateDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderUpdateDTO;
import org.springframework.data.domain.Page;
import pl.filiphagno.spring6backend.entities.BeerOrder;

import java.util.Optional;
import java.util.UUID;

public interface BeerOrderService {
    Page<BeerOrderDTO> getBeerOrders(Integer pageNumber, Integer pageSize);
    Optional<BeerOrderDTO> getBeerOrderById(UUID beerOrderId);
    BeerOrderDTO updateBeerOrderById(UUID beerOrderId, BeerOrderUpdateDTO beerOrderUpdateDTO);
    BeerOrder createBeerOrder(BeerOrderCreateDTO beerOrderCreateDTO);

    Boolean deleteBeerOrderById(UUID beerOrderId);
}
