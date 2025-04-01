package pl.filiphagno.spring6backend.mappers;

import pl.filiphagno.spring6backend.entities.Customer;
import pl.filiphagno.spring6backend.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Created by jt, Spring Framework Guru.
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);

}
