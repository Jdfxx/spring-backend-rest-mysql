package pl.filiphagno.spring6backend.mappers;

import guru.springframework.spring6restmvcapi.model.BeerDTO;
import pl.filiphagno.spring6backend.entities.Beer;
import pl.filiphagno.spring6backend.entities.BeerAudit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface BeerMapper {

    @Mapping(target="categories", ignore = true)
    @Mapping(target="beerOrderLines", ignore = true)
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

    @Mapping(target = "createdDateAudit", ignore = true)
    @Mapping(target = "auditId", ignore = true)
    @Mapping(target = "auditEventType", ignore = true)
    @Mapping(target = "principalName", ignore = true)
    BeerAudit beerToBeerAudit(Beer beer);

}
