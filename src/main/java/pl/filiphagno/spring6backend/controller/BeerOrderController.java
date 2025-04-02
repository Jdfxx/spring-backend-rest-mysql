package pl.filiphagno.spring6backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.filiphagno.spring6backend.entities.BeerOrder;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerOrderController {
    public static final String BEER_ORDER = "/api/v1/beerOrder";


    @GetMapping(BEER_ORDER)
    public ResponseEntity getBeerOrder() {
        return ResponseEntity.ok().build();
    }

}
