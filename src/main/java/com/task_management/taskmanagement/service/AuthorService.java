package com.task_management.taskmanagement.service;

import com.task_management.taskmanagement.dto.AuthorDTO;
import com.task_management.taskmanagement.entity.Author;
import com.task_management.taskmanagement.exceptions.ResourceNotFoundException;
import com.task_management.taskmanagement.mapper.AuthorMapper;
import com.task_management.taskmanagement.repository.AuthorRepository;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper.INSTANCE::toAuthorDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        return AuthorMapper.INSTANCE.toAuthorDTO(author);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.toAuthor(authorDTO);
        log.info("Author Entity {}", author);
        author = authorRepository.save(author);
        return AuthorMapper.INSTANCE.toAuthorDTO(author);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        author.setName(authorDTO.getName());
        author = authorRepository.save(author);
        return AuthorMapper.INSTANCE.toAuthorDTO(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        authorRepository.delete(author);
    }
}
