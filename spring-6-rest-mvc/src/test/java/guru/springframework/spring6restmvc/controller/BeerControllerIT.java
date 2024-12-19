package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.mappers.BeerMapper;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController controller;

    @Autowired
    BeerRepository repository;

    @Autowired
    BeerMapper mapper;

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.handlePut(UUID.randomUUID(), BeerDTO.builder().build());
        });
    }

    @Test
    void testUpdateExistingBeer() {
        Beer beer = repository.findAll().get(0);
        BeerDTO beerDTO = mapper.beerToBeerDTO(beer);

        beerDTO.setId(null);
        beerDTO.setVersion(null);
        final String beerName = "UPDATED";
        beerDTO.setName(beerName);

        ResponseEntity responseEntity = controller.handlePut(beer.getId(), beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        Beer updatedBeer = repository.findById(beer.getId()).get();
        assertThat(updatedBeer.getName()).isEqualTo(beerName);
    }

    @Rollback
    @Transactional
    @Test
    void testSaveNewBeer() {
        BeerDTO beerDTO = BeerDTO.builder()
                .name("Beer")
                .build();

        ResponseEntity responseEntity = controller.handlePost(beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[locationUUID.length-1]);

        Beer beer = repository.findById(savedUUID).get();
        assertThat(beer).isNotNull();
    }

    @Test
    void testGetBeerById() {
        Beer beer = repository.findAll().get(0);
        BeerDTO dto = controller.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testBeerIdNotFound() {
        assertThrows(NotFoundException.class, () ->
                controller.getBeerById(UUID.randomUUID()));
    }

    @Test
    void testListBeers() {
        List<BeerDTO> dtos = controller.getAllBeers();
        assertThat(dtos.size()).isEqualTo(6);
    }

    @Test
    @Transactional
    @Rollback
    void testEmptyList() {
        repository.deleteAll();
        List<BeerDTO> dtos = controller.getAllBeers();
        assertThat(dtos.size()).isEqualTo(0);
    }
}