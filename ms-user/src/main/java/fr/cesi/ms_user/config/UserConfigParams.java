package fr.cesi.ms_user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user.params")
public record UserConfigParams(int x, int y) {
}
