package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;


    @Builder
    @Data
    public class BeerDTO {
        private UUID id;
        private Integer version;
        private String name;
        private BigDecimal price;
        private String upc;
        private BeerStyle style;
        private String description;
        private Integer quantityOnHand;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }
