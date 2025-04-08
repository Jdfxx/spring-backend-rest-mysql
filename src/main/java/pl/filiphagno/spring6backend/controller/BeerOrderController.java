package pl.filiphagno.spring6backend.controller;

import guru.springframework.spring6restmvcapi.model.BeerOrderCreateDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderDTO;
import guru.springframework.spring6restmvcapi.model.BeerOrderUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.spring6backend.services.BeerOrderService;

import java.net.URI;
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

        return ResponseEntity.created(URI.create(BEER_ORDER + "/" + savedBeerOrder.getId().toString()))
                .body("Beer Order Created Successfully");
    }

    @PutMapping(BEER_ORDER_ID)
    public ResponseEntity<BeerOrderDTO>  updateBeerOrderById(@PathVariable("beerOrderId") UUID beerOrderId,
                                            @RequestBody BeerOrderUpdateDTO beerOrderUpdateDTO) {
        return ResponseEntity.ok(beerOrderService.updateBeerOrderById(beerOrderId, beerOrderUpdateDTO));
    }

    @DeleteMapping(BEER_ORDER_ID)
    public ResponseEntity<String> deleteBeerOrderById(@PathVariable("beerOrderId") UUID beerOrderId) {
        if(!beerOrderService.deleteBeerOrderById(beerOrderId)){
            throw new NotFoundException();
        }

        return new ResponseEntity<>("Beer Order Deleted Successfully", HttpStatus.NO_CONTENT);
    }

}
