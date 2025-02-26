package fr.cesi.ms_author.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "author.params")
public record AuthorConfigParams(int x, int y) {
}
