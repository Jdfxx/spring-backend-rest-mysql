package pl.filiphagno.spring6backend.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import pl.filiphagno.spring6backend.entities.Beer;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class BeerDeletedEvent {

    private UUID beerId;

    private Authentication authentication;
}
