package pl.filiphagno.spring6backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.mappers.BeerOrderMapper;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;
import pl.filiphagno.spring6backend.repositories.BeerOrderRepository;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BeerOrderServiceImpl implements BeerOrderService {

    final private BeerOrderRepository beerOrderRepository;

    final private BeerOrderMapper beerOrderMapper;

    @Override
    public Page<BeerOrderDTO> getBeerOrders(Integer pageNumber, Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = 0;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = 25;
        }

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Page<BeerOrder> beerOrders = beerOrderRepository.findAll(pageRequest);

        return beerOrders.map(beerOrderMapper::beerOrderToBeerOrderDTO);
    }

    @Override
    public Optional<BeerOrderDTO> getBeerOrderById(UUID beerOrderId) {
        return Optional.ofNullable(beerOrderMapper.beerOrderToBeerOrderDTO(beerOrderRepository.findById(beerOrderId).orElse(null)));
    }
}
