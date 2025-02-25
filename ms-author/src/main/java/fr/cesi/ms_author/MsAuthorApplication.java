package fr.cesi.ms_author;

import fr.cesi.ms_author.entities.Author;
import fr.cesi.ms_author.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsAuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthorApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AuthorRepository repo, RepositoryRestConfiguration config) {
		return args -> {
			config.exposeIdsFor(Author.class);
			repo.save(new Author(null, "buthor01", "author1@author.fr"));
			repo.save(new Author(null, "author02", "author2@author.fr"));
			repo.save(new Author(null, "cuthor03", "author3@author.fr"));
			repo.findAll().forEach(author -> {
				System.out.println(author.getName());
			});
		};
	}
}
