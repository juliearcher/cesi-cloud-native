package fr.cesi.ms_author.models;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Article {
    private Long id;
    private String title;
    private String content;
}