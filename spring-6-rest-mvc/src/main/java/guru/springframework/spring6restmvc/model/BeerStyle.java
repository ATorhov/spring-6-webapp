package guru.springframework.spring6restmvc.model;

import lombok.Getter;

    @Getter
    public enum BeerStyle {

        ALE("A full-bodied beer with a rich flavor."),
        LAGER("A clean, crisp, and refreshing beer."),
        PILSNER("A pale, golden lager with a spicy hop flavor."),
        WEISS("A wheat beer with a fruity aroma and light taste."),
        RADLER("A beer mixed with citrus soda for a refreshing drink."),
        DARK("A rich, roasted beer with a strong malt flavor.");

        private final String description;


        BeerStyle(String description) {
            this.description = description;
        }
    }
