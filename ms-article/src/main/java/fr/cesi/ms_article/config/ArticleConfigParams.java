package fr.cesi.ms_article.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "article.params")
public record ArticleConfigParams(int x, int y) {
}
