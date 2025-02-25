package fr.cesi.ms_article.projections;

import fr.cesi.ms_article.entities.Article;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "web", types = {Article.class})
public interface ArticleProjectionWeb {
    String getTitle();
    String getContent();
}
