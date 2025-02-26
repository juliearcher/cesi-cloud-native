package fr.cesi.ms_rating.web;

import fr.cesi.ms_rating.entities.Rating;
import fr.cesi.ms_rating.feign.ArticleRestClient;
import fr.cesi.ms_rating.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class RatingRestController {
    private RatingRepository ratingRepository;
    private ArticleRestClient articleRestClient;

    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/ratings/{id}")
    public Rating getRating(@PathVariable Long id) {
        Rating rating = ratingRepository.findById(id).orElse(null);
        return rating;
    }

    @PostMapping("/ratings")
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping("/ratings/{id}")
    public Rating updateRating(@RequestBody Rating rating, @PathVariable Long id) {
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @DeleteMapping("/ratings/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingRepository.deleteById(id);
    }
}
