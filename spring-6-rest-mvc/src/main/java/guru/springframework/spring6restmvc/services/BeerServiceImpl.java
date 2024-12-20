package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Kozel")
                .style(BeerStyle.LAGER)
                .description(BeerStyle.LAGER.getDescription())
                .price(BigDecimal.valueOf(14.23))
                .upc("12365")
                .quantityOnHand(23)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Heineken")
                .style(BeerStyle.ALE)
                .description(BeerStyle.ALE.getDescription())
                .price(BigDecimal.valueOf(15.99))
                .upc("45678")
                .quantityOnHand(50)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Guinness")
                .style(BeerStyle.DARK)
                .description(BeerStyle.DARK.getDescription())
                .price(BigDecimal.valueOf(18.45))
                .upc("78901")
                .quantityOnHand(34)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer4 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Budweiser")
                .style(BeerStyle.RADLER)
                .description(BeerStyle.RADLER.getDescription())
                .price(BigDecimal.valueOf(13.75))
                .upc("23456")
                .quantityOnHand(40)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer5 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Corona")
                .style(BeerStyle.PILSNER)
                .description(BeerStyle.PILSNER.getDescription())
                .price(BigDecimal.valueOf(16.30))
                .upc("34567")
                .quantityOnHand(45)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer6 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Sierra Nevada Pale Ale")
                .style(BeerStyle.LAGER)
                .description(BeerStyle.LAGER.getDescription())
                .price(BigDecimal.valueOf(19.99))
                .upc("56789")
                .quantityOnHand(25)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
        beerMap.put(beer4.getId(), beer4);
        beerMap.put(beer5.getId(), beer5);
        beerMap.put(beer6.getId(), beer6);

    }


    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        log.info("get Beer By Id service was called");
        return Optional.of(beerMap.get(id));
    }

    @Override
    public List<BeerDTO> listBeers() {
        return new ArrayList<BeerDTO>(beerMap.values());
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        BeerDTO beerSaved = BeerDTO.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .name(beer.getName())
                .price(beer.getPrice())
                .upc(beer.getUpc())
                .quantityOnHand(beer.getQuantityOnHand())
                .style(beer.getStyle())
                .description(beer.getStyle().getDescription())
                .version(beer.getVersion())
                .build();

        beerMap.put(beerSaved.getId(), beerSaved);
        return beerSaved;
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
        BeerDTO beerToUpdate = beerMap.get(beerId);
        beerToUpdate.setName(beer.getName());
        beerToUpdate.setPrice(beer.getPrice());
        beerToUpdate.setUpc(beer.getUpc());
        beerToUpdate.setQuantityOnHand(beer.getQuantityOnHand());
        beerToUpdate.setStyle(beer.getStyle());
        beerToUpdate.setVersion(beer.getVersion());
        beerToUpdate.setDescription(beer.getDescription());
        beerToUpdate.setUpdatedAt(LocalDateTime.now());
        return Optional.of(beerToUpdate);
    }

    @Override
    public Boolean removeById(UUID beerId) {
        beerMap.remove(beerId);
        return true;
    }

    @Override
    public Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer) {
        BeerDTO beerToPatch = beerMap.get(beerId);
        boolean updated = false;

        if (StringUtils.hasText(beer.getName())) {
            beerToPatch.setName(beer.getName());
            updated = true;
        }
        if (StringUtils.hasText(beer.getDescription())) {
            beerToPatch.setDescription(beer.getDescription());
            updated = true;
        }
        if (StringUtils.hasText(beer.getUpc())) {
            beerToPatch.setUpc(beer.getUpc());
            updated = true;
        }
        if (beer.getPrice() != null) {
            beerToPatch.setPrice(beer.getPrice());
            updated = true;
        }
        if (beer.getStyle() != null) {
            beerToPatch.setStyle(beer.getStyle());
            updated = true;
        }
        if (beer.getQuantityOnHand() != null) {
            beerToPatch.setQuantityOnHand(beer.getQuantityOnHand());
            updated = true;
        }
        if (updated) {
            beerToPatch.setUpdatedAt(LocalDateTime.now());
        }
        return Optional.of(beerToPatch);
    }
}