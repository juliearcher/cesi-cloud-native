package fr.cesi.ms_author.web;


import fr.cesi.ms_author.entities.Author;
import fr.cesi.ms_author.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
public class AuthorRestController  {
    private AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @PostMapping("/authors")
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
