package fr.cesi.ms_rating.feign;

import fr.cesi.ms_rating.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-user")
public interface UserRestClient {
    @GetMapping("/users/{id}")
    User findUserById(@PathVariable Long id);

    @GetMapping("/users")
    List<User> getAllUsers();
}
