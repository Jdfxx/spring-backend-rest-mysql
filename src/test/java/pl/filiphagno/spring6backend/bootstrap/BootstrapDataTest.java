package pl.filiphagno.spring6backend.bootstrap;

import pl.filiphagno.spring6backend.repositories.BeerOrderRepository;
import pl.filiphagno.spring6backend.repositories.BeerRepository;
import pl.filiphagno.spring6backend.repositories.CustomerRepository;
import pl.filiphagno.spring6backend.services.BeerCsvService;
import pl.filiphagno.spring6backend.services.BeerCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BeerCsvServiceImpl.class)
class BootstrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerCsvService csvService;

    BootstrapData bootstrapData;

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(beerRepository, customerRepository,
                csvService, beerOrderRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
        assertThat(beerOrderRepository.count()).isGreaterThan(0);
    }
}





