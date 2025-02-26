package fr.cesi.ms_author.feign;

import fr.cesi.ms_author.models.Article;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-article")
public interface ArticleRestClient {
    @GetMapping("/articles/{id}")
    Article findArticleById(@PathVariable Long id);

    @GetMapping("/articles")
    List<Article> getAllArticles();

    @GetMapping("/articles")
    List<Article> getAllArticlesofAuthor(@RequestParam Long authorId);
}
