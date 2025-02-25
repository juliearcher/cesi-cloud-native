package fr.cesi.ms_article.repository;

import fr.cesi.ms_article.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
