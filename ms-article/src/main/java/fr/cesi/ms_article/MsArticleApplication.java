package fr.cesi.ms_article;

import fr.cesi.ms_article.entities.Article;
import fr.cesi.ms_article.entities.Comment;
import fr.cesi.ms_article.feign.AuthorRestClient;
import fr.cesi.ms_article.feign.UserRestClient;
import fr.cesi.ms_article.models.Author;
import fr.cesi.ms_article.models.User;
import fr.cesi.ms_article.repository.ArticleRepository;
import fr.cesi.ms_article.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class MsArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsArticleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ArticleRepository repo,
							CommentRepository commentRepository,
							AuthorRestClient authorRestClient,
							UserRestClient userRestClient, ArticleRepository articleRepository) {
		return args -> {
			Collection<Author> authors = authorRestClient.getAllAuthors().getContent();
			Collection<User> users = userRestClient.getAllUsers().getContent();

			authors.forEach(author -> {
				System.out.println(author.getName() + " " + author.getId());
				Article article = Article.builder()
						.title("Article de ")
						.content("Super contenu d'article de " + author.getName())
						.authorId(author.getId() != null ? author.getId() : 0)
						.build();
				articleRepository.save(article);
				users.forEach(user -> {
					System.out.println(user.getUsername());
					Comment comment = Comment.builder()
							.article(article)
							.content("Un commentaire sur l'article de " + author.getName() + "signé par " + user.getUsername())
							.userId(user.getId() != null ? user.getId() : 0)
							.createdAt(new Date())
							.updatedAt(new Date())
							.build();
					commentRepository.save(comment);
				});
			});

			/*repositoryRestConfiguration.exposeIdsFor(Article.class);
			repo.save(new Article(null, "titre01", "contenu01"));
			repo.save(new Article(null, "la migration des hirondelles", "les hirondelles migrent en printemps et en automne"));
			repo.save(new Article(null, "Exploitation des ggazs de schiste", "Les USA ont autorisé dans certains états"));
			repo.findAll().forEach(article -> {
				System.out.println(article.getTitle());
			});*/
		};
	}


}
