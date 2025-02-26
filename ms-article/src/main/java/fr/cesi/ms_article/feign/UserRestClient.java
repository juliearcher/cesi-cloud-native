package fr.cesi.ms_article.feign;

import fr.cesi.ms_article.models.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "ms-user")
public interface UserRestClient {
    @GetMapping("/users/{id}")
    @CircuitBreaker(name="msUserCB", fallbackMethod = "getDefaultUser")
    User findUserById(@PathVariable Long id);

    @GetMapping("/users")
    @CircuitBreaker(name="msUserCB", fallbackMethod = "getDefaultUsers")
    List<User> getAllUsers();

    default User getDefaultUser(Long id, Exception e) {
        return User.builder()
                .id(id)
                .username("default username")
                .email("default email")
                .build();
    }

    default List<User> getDefaultUsers(Exception e) {
        return new ArrayList<>();
    }
}
