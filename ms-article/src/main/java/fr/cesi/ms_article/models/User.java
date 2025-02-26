package fr.cesi.ms_article.models;

import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
}
