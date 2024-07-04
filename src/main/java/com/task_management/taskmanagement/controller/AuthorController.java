package com.task_management.taskmanagement.controller;


import com.task_management.taskmanagement.dto.AuthorDTO;
import com.task_management.taskmanagement.service.AuthorService;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        log.info("data it's getting{}", authorDTO);
        return ResponseEntity.ok(authorService.createAuthor(authorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
