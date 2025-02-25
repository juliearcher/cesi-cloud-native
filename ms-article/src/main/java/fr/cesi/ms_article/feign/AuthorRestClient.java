package fr.cesi.ms_article.feign;

import fr.cesi.ms_article.models.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-author")
public interface AuthorRestClient {

    @GetMapping("/authors/{id}")
    Author findAuthorById(@PathVariable Long id);

    @GetMapping("/authors")
    PagedModel<Author> getAllAuthors();
}
