package fr.cesi.ms_article.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cesi.ms_article.models.Author;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();
    private long authorId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Author author;
}
