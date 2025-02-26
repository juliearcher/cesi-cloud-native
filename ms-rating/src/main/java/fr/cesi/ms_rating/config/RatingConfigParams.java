package fr.cesi.ms_rating.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rating.params")
public record RatingConfigParams(int x, int y) {
}
