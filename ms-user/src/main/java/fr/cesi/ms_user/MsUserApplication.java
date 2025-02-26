package fr.cesi.ms_user;

import fr.cesi.ms_user.config.UserConfigParams;
import fr.cesi.ms_user.entities.User;
import fr.cesi.ms_user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(UserConfigParams.class)
public class MsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(UserRepository repo, RepositoryRestConfiguration config) {
		return args -> {
			config.exposeIdsFor(User.class);
			repo.save(new User(null, "user1", "user@user1.fr", "user1pass"));
			repo.save(new User(null, "user2", "user@user2.fr", "user2pass"));
			repo.save(new User(null, "user3", "user@user3.fr", "user3pass"));
			repo.findAll().forEach(user -> {
				System.out.println(user.getUsername());
			});
		};
	}
}
