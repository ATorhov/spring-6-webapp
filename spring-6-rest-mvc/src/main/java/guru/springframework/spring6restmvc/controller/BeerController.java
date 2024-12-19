package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/beers/")
public class BeerController {

    private final BeerService beerService;

    public static final String BEER_PATH =  "/api/v1/beers/";
    public static final String BEER_BY_ID_URL = "{beerId}";


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(BEER_BY_ID_URL)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {
        log.info("get Beer By Id controller was called!!");
        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerDTO> getAllBeers() {
        return beerService.listBeers();
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody BeerDTO beer) {

        BeerDTO savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", BEER_PATH + savedBeer.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping(BEER_BY_ID_URL)
    public ResponseEntity handlePut(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {
       if (beerService.updateBeerById(beerId, beer).isEmpty()){
           throw new NotFoundException();
       }
        HttpHeaders headers = new HttpHeaders();

       return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_BY_ID_URL)
    public ResponseEntity handleDelete(@PathVariable UUID beerId) {
        beerService.removeById(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(BEER_BY_ID_URL)
    public ResponseEntity handlePatch(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {
        beerService.patchBeerById(beerId, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
