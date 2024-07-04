package com.task_management.taskmanagement.repository;

import com.task_management.taskmanagement.entity.Author;
import com.task_management.taskmanagement.entity.Book;
import com.task_management.taskmanagement.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);
}
