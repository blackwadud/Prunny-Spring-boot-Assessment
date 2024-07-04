package com.task_management.taskmanagement.controller;

import com.task_management.taskmanagement.dto.BookDTO;
import com.task_management.taskmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.createBook(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/author/{authorId}")
    public ResponseEntity<List<BookDTO>> findBooksByAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(bookService.findBooksByAuthor(authorId));
    }

    @GetMapping("/search/genre/{genreId}")
    public ResponseEntity<List<BookDTO>> findBooksByGenre(@PathVariable Long genreId) {
        return ResponseEntity.ok(bookService.findBooksByGenre(genreId));
    }
}
