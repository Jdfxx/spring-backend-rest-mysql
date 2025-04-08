package pl.filiphagno.spring6backend.listeners;

import guru.springframework.spring6restmvcapi.events.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderPlacedListener {


    @Async
    @EventListener
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        // send to kafka
        System.out.println("Order Placed Event");
    }

}
