package pl.filiphagno.spring6backend.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.filiphagno.spring6backend.events.BeerUpdatedEvent;
import pl.filiphagno.spring6backend.mappers.BeerMapper;
import pl.filiphagno.spring6backend.repositories.BeerAuditRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerUpdatedListener {

    private final BeerMapper beerMapper;
    private final BeerAuditRepository beerAuditRepository;

    @EventListener
    @Async
    public void listen(BeerUpdatedEvent event) {
        var beerAudit = beerMapper.beerToBeerAudit(event.getBeer());
        beerAudit.setAuditEventType("BEER_UPDATED");

        if(event.getAuthentication() != null && event.getAuthentication().getName() != null) {
            beerAudit.setPrincipalName(event.getAuthentication().getName());
        }
        var savedBeerAudit = beerAuditRepository.save(beerAudit);
        log.info("Beer Audit saved for Beer {}", savedBeerAudit.getId());

    }
}
