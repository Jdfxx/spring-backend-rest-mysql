package pl.filiphagno.spring6backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.spring6backend.model.BeerOrderCreateDTO;
import pl.filiphagno.spring6backend.model.BeerOrderDTO;
import pl.filiphagno.spring6backend.services.BeerOrderService;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerOrderController {
    public static final String BEER_ORDER = "/api/v1/beerOrder";
    public static final String BEER_ORDER_ID = BEER_ORDER + "/{beerOrderId}";

    private final BeerOrderService beerOrderService;

    @GetMapping(BEER_ORDER)
    public Page<BeerOrderDTO> getBeerOrder(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
            ) {
        return beerOrderService.getBeerOrders(pageNumber, pageSize);
    }

    @GetMapping(BEER_ORDER_ID)
    public BeerOrderDTO getBeerOrderById(@PathVariable("beerOrderId") UUID beerOrderId) {
        return beerOrderService.getBeerOrderById(beerOrderId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(BEER_ORDER)
    public ResponseEntity<String> createBeerOrder(@RequestBody BeerOrderCreateDTO beerOrderCreateDTO) {
        var savedBeerOrder = beerOrderService.createBeerOrder(beerOrderCreateDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_ORDER + "/" + savedBeerOrder.getId().toString());

        return ResponseEntity.created(headers.getLocation()).headers(headers).body("Beer Order Created Successfully");
    }
}
