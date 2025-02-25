package fr.cesi.ms_article.projections;

import fr.cesi.ms_article.entities.Article;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Article.class)
public interface ArticleProjectionMobile {
    String getTitle();
}
