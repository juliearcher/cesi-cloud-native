package fr.cesi.ms_rating.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
}
