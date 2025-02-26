package fr.cesi.ms_article.web;

import fr.cesi.ms_article.entities.Article;
import fr.cesi.ms_article.feign.AuthorRestClient;
import fr.cesi.ms_article.feign.UserRestClient;
import fr.cesi.ms_article.repository.ArticleRepository;
import fr.cesi.ms_article.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ArticleRestController  {
    private ArticleRepository articleRepository;
    private UserRestClient userRestClient;
    private AuthorRestClient authorRestClient;

    @GetMapping("/articles")
    public List<Article> getAllArticles(@RequestParam(required = false, name = "authorId") Long authorId) {
        List<Article> articles = authorId == null ? articleRepository.findAll() : articleRepository.findByAuthorId(authorId);
        articles.forEach(article -> {
            System.out.println(article.getAuthorId());
            if (authorId == null)
                article.setAuthor(authorRestClient.findAuthorById(article.getAuthorId()));
            article.getComments().forEach(comment -> comment.setUser(userRestClient.findUserById(comment.getUserId())));
        });
        return articles;
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null) {
            article.setAuthor(authorRestClient.findAuthorById(article.getAuthorId()));
            article.getComments().forEach(comment -> comment.setUser(userRestClient.findUserById(comment.getUserId())));
        }
        return article;
    }

    @PostMapping("/articles")
    public Article saveArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/articles/{id}")
    public Article updateArticle(@RequestBody Article article, @PathVariable Long id) {
        article.setId(id);
        return articleRepository.save(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

}
