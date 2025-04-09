package pl.filiphagno.spring6backend.listeners;

import guru.springframework.spring6restmvcapi.events.DrinkPreparedEvent;
import guru.springframework.spring6restmvcapi.model.BeerOrderLineStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.filiphagno.spring6backend.config.KafkaConfig;
import pl.filiphagno.spring6backend.repositories.BeerOrderLineRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class DrinkPreparedListener {

    private final BeerOrderLineRepository beerOrderLineRepository;

    @Transactional
    @KafkaListener(groupId = "DrinkPreparedListener", topics = KafkaConfig.DRINK_PREPARED_TOPIC)
    public void listen(DrinkPreparedEvent event) {

        log.debug("Drink Prepared Event Received");

        beerOrderLineRepository.findById(event.getBeerOrderLine().getId()).ifPresentOrElse(beerOrderLine -> {

            beerOrderLine.setBeerOrderLineStatus(BeerOrderLineStatus.COMPLETE);

            beerOrderLineRepository.saveAndFlush(beerOrderLine);
        }, () -> log.error("Beer Order Line Not Found!"));
    }
}