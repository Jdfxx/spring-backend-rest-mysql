package pl.filiphagno.spring6backend.listeners;

import guru.springframework.spring6restmvcapi.events.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.filiphagno.spring6backend.config.KafkaConfig;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderPlacedListener {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Async
    @EventListener
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        // send to kafka
        log.debug("Order Placed Event Received");

        kafkaTemplate.send(KafkaConfig.ORDER_PLACED_TOPIC, orderPlacedEvent);
    }
}
