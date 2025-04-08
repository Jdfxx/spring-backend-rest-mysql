package pl.filiphagno.spring6backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvcapi.model.*;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pl.filiphagno.spring6backend.entities.BeerOrder;
import pl.filiphagno.spring6backend.model.*;
import pl.filiphagno.spring6backend.repositories.BeerOrderRepository;
import pl.filiphagno.spring6backend.repositories.BeerRepository;
import pl.filiphagno.spring6backend.repositories.CustomerRepository;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class BeerOrderControllerTestIT {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    public static final SecurityMockMvcRequestPostProcessors.JwtRequestPostProcessor jwtRequestPostProcessor =
            jwt().jwt(jwt -> {
                jwt.claims(claims -> {
                            claims.put("scope", "message-read");
                            claims.put("scope", "message-write");
                        })
                        .subject("messaging-client")
                        .notBefore(Instant.now().minusSeconds(5l));
            });

    @Rollback
    @Transactional
    @Test
    void testDeleteBeerOrderById() throws Exception {
        val beerOrder = beerOrderRepository.findAll().getFirst();

        mockMvc.perform(delete(BeerOrderController.BEER_ORDER_ID, beerOrder.getId())
                        .contentType("application/json")
                        .with(jwtRequestPostProcessor))
                .andExpect(status().isNoContent());

        assertThat(beerOrderRepository.findById(beerOrder.getId()).isEmpty());

        mockMvc.perform(delete(BeerOrderController.BEER_ORDER_ID, beerOrder.getId())
                        .contentType("application/json")
                        .with(jwtRequestPostProcessor))
                .andExpect(status().isNotFound());

    }


    @Rollback
    @Transactional
    @Test
    void testUpdateOrder() throws Exception {
        val beerOrder = beerOrderRepository.findAll().getFirst();

        Set<BeerOrderLineUpdateDTO> lines = new HashSet<>();

        beerOrder.getBeerOrderLines().forEach(beerOrderLine -> {
            lines.add(BeerOrderLineUpdateDTO.builder()
                    .id(beerOrderLine.getId())
                    .beerId(beerOrderLine.getBeer().getId())
                    .orderQuantity(beerOrderLine.getOrderQuantity())
                    .quantityAllocated(beerOrderLine.getQuantityAllocated())
                    .build());
        });

        val beerOrderUpdateDTO = BeerOrderUpdateDTO.builder()
                .customerId(beerOrder.getCustomer().getId())
                .customerRef("TestRef")
                .beerOrderLines(lines)
                .beerOrderShipment(BeerOrderShipmentUpdateDTO.builder()
                        .trackingNumber("123456")
                        .build())
                .build();

        mockMvc.perform(put(BeerOrderController.BEER_ORDER_ID, beerOrder.getId())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(beerOrderUpdateDTO))
                        .with(jwtRequestPostProcessor))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerRef", is("TestRef")));
    }

    @Rollback
    @Transactional
    @Test
    void testCreateBeerOrder() throws Exception {
        val customer = customerRepository.findAll().getFirst();
        val beer = beerRepository.findAll().getFirst();

        val beerOrderCreateDTO = BeerOrderCreateDTO.builder()
                .customerId(customer.getId())
                .beerOrderLines(Set.of(BeerOrderLineCreateDTO.builder()
                        .beerId(beer.getId())
                        .orderQuantity(1)
                        .build()))
                .build();

        mockMvc.perform(post(BeerOrderController.BEER_ORDER)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(beerOrderCreateDTO))
                        .with(jwtRequestPostProcessor))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void getListOrder() throws Exception {
        mockMvc.perform(get(BeerOrderController.BEER_ORDER)
                        .with(jwtRequestPostProcessor)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", greaterThan(0)));
    }

    @Test
    void getOrderById() throws Exception {
        BeerOrder beerOrder = beerOrderRepository.findAll().getFirst();
        var id = beerOrder.getId();

        mockMvc.perform(get(BeerOrderController.BEER_ORDER_ID, id)
                        .with(jwtRequestPostProcessor)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(beerOrder.getId().toString())));
    }
}
