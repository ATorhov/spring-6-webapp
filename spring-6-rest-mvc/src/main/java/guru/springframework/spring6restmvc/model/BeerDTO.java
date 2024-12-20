package guru.springframework.spring6restmvc.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;


    @Builder
    @Data
    public class BeerDTO {
        private UUID id;
        private Integer version;
        @NotBlank
        @NotNull
        @Size(min = 2, max = 50)
        @Column(length = 50, nullable = false)
        private String name;
        @NotNull
        private BigDecimal price;
        @NotBlank
        @NotNull
        private String upc;
        @NotNull
        private BeerStyle style;
        private String description;
        private Integer quantityOnHand;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }
