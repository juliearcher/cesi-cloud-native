package fr.cesi.ms_rating.repository;

import fr.cesi.ms_rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
