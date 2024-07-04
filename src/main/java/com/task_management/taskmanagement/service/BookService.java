package com.task_management.taskmanagement.service;


import com.task_management.taskmanagement.dto.BookDTO;
import com.task_management.taskmanagement.entity.Author;
import com.task_management.taskmanagement.entity.Book;
import com.task_management.taskmanagement.entity.Genre;
import com.task_management.taskmanagement.exceptions.ResourceNotFoundException;
import com.task_management.taskmanagement.mapper.BookMapper;
import com.task_management.taskmanagement.repository.AuthorRepository;
import com.task_management.taskmanagement.repository.BookRepository;
import com.task_management.taskmanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);

        // Fetch author and genre from the repository and set them in the book entity
        Author author = authorRepository.findById(bookDTO.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Genre genre = genreRepository.findById(bookDTO.getGenre().getId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        book.setAuthor(author);
        book.setGenre(genre);

        book = bookRepository.save(book);
        return bookMapper.toBookDTO(book);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        Author author = authorRepository.findById(bookDTO.getAuthor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + bookDTO.getAuthor().getId()));
        Genre genre = genreRepository.findById(bookDTO.getGenre().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + bookDTO.getGenre().getId()));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(author);
        book.setGenre(genre);
        book = bookRepository.save(book);

        return bookMapper.toBookDTO(book);
    }
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        bookRepository.delete(book);
    }

    public List<BookDTO> findBooksByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + authorId));
        return bookRepository.findByAuthor(author).stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> findBooksByGenre(Long genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + genreId));
        return bookRepository.findByGenre(genre).stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .collect(Collectors.toList());
    }
}
