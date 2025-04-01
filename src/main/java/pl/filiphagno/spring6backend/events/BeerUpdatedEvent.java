package pl.filiphagno.spring6backend.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import pl.filiphagno.spring6backend.entities.Beer;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BeerUpdatedEvent {
    private Beer beer;

    private Authentication authentication;
}

