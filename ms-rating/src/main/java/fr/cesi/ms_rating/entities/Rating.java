package fr.cesi.ms_rating.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cesi.ms_rating.models.Article;
import fr.cesi.ms_rating.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int note;
    private Long articleId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Article article;
    private Long userId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
}
