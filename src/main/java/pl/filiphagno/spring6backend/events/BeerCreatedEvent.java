package pl.filiphagno.spring6backend.events;

import pl.filiphagno.spring6backend.entities.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;

/**
 * Created by jt, Spring Framework Guru.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BeerCreatedEvent {

    private Beer beer;

    private Authentication authentication;
}
