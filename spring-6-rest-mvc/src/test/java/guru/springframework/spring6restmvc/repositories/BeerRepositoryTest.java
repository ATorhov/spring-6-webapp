package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveBeer() {

        Beer savedBeer = beerRepository.save(Beer.builder()
                        .name("Beer")
                        .build());

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getName()).isEqualTo("Beer");
        assertThat(savedBeer.getId()).isNotNull();

    }

}