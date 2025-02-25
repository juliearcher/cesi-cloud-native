package fr.cesi.ms_user.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="UTILISATEURS")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
}
