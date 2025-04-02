package pl.filiphagno.spring6backend.services;

import org.springframework.data.domain.Page;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;

import java.util.Optional;
import java.util.UUID;

public interface BeerOrderService {
    Page<BeerOrderDTO> getBeerOrders(Integer pageNumber, Integer pageSize);
    Optional<BeerOrderDTO> getBeerOrderById(UUID beerOrderId);
}
