package guru.springframework.spring6restmvc.bootstrap;


import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    //private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    .name("Kozel")
                    .style(BeerStyle.LAGER)
                    .description(BeerStyle.LAGER.getDescription())
                    .price(BigDecimal.valueOf(14.23))
                    .upc("12365")
                    .quantityOnHand(23)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .name("Heineken")
                    .style(BeerStyle.ALE)
                    .description(BeerStyle.ALE.getDescription())
                    .price(BigDecimal.valueOf(15.99))
                    .upc("45678")
                    .quantityOnHand(50)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .name("Guinness")
                    .style(BeerStyle.DARK)
                    .description(BeerStyle.DARK.getDescription())
                    .price(BigDecimal.valueOf(18.45))
                    .upc("78901")
                    .quantityOnHand(34)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer4 = Beer.builder()
                    .name("Budweiser")
                    .style(BeerStyle.RADLER)
                    .description(BeerStyle.RADLER.getDescription())
                    .price(BigDecimal.valueOf(13.75))
                    .upc("23456")
                    .quantityOnHand(40)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer5 = Beer.builder()
                    .name("Corona")
                    .style(BeerStyle.PILSNER)
                    .description(BeerStyle.PILSNER.getDescription())
                    .price(BigDecimal.valueOf(16.30))
                    .upc("34567")
                    .quantityOnHand(45)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer6 = Beer.builder()
                    .name("Sierra Nevada Pale Ale")
                    .style(BeerStyle.LAGER)
                    .description(BeerStyle.LAGER.getDescription())
                    .price(BigDecimal.valueOf(19.99))
                    .upc("56789")
                    .quantityOnHand(25)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(List.of(
                    beer1, beer2, beer3, beer4, beer5, beer6));

        }
    }
}
