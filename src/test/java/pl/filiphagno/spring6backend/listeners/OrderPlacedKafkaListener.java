package pl.filiphagno.spring6backend.listeners;

import guru.springframework.spring6restmvcapi.events.OrderPlacedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.filiphagno.spring6backend.config.KafkaConfig;

import java.util.concurrent.atomic.AtomicInteger;

@Component
class OrderPlacedKafkaListener {
    AtomicInteger messageCounter = new AtomicInteger(0);

    @KafkaListener(groupId = "KafkaIntegrationTest", topics = KafkaConfig.ORDER_PLACED_TOPIC)
    public void receive(OrderPlacedEvent orderPlacedEvent) {
        System.out.println("Received Message: " + orderPlacedEvent);
        messageCounter.incrementAndGet();
    }
}