package pl.filiphagno.spring6backend.listeners;

import pl.filiphagno.spring6backend.events.BeerCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BeerCreatedListener {

    @EventListener
    @Async
    public void listen(BeerCreatedEvent event) {
        System.out.println("I heard a beer was created!");
        System.out.println(event.getBeer().getId());

        //todo impl - add real implementation to persist audit record
    }
}
