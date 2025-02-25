package fr.cesi.ms_article.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cesi.ms_article.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Article article;
    private long userId;
    @Transient
    private User user;
}
