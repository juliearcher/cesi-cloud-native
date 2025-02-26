package fr.cesi.ms_rating;

import fr.cesi.ms_rating.entities.Rating;
import fr.cesi.ms_rating.feign.ArticleRestClient;
import fr.cesi.ms_rating.feign.UserRestClient;
import fr.cesi.ms_rating.models.Article;
import fr.cesi.ms_rating.models.User;
import fr.cesi.ms_rating.repository.RatingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class MsRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRatingApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserRestClient userRestClient,
							ArticleRestClient articleRestClient, RatingRepository ratingRepository) {
		return args -> {
			Random r = new Random();
			Collection<Article> articles = articleRestClient.getAllArticles();
			Collection<User> users = userRestClient.getAllUsers().getContent();

			articles.forEach(article -> {
				System.out.println(article.getTitle() + " " + article.getId());
				users.forEach(user -> {
					System.out.println(user.getUsername());
					int randomValue = Math.abs(r.nextInt() % 11);
					Rating rating = Rating.builder()
							.note(randomValue)
							.userId(user.getId())
							.articleId(article.getId())
							.build();
					ratingRepository.save(rating);
				});
			});
		};
	}
}
