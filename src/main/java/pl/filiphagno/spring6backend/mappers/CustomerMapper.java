package pl.filiphagno.spring6backend.mappers;

import guru.springframework.spring6restmvcapi.model.CustomerDTO;
import pl.filiphagno.spring6backend.entities.Customer;
import org.mapstruct.Mapper;


@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);

}
