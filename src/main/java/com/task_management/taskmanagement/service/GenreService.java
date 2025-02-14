package com.task_management.taskmanagement.service;


import com.task_management.taskmanagement.dto.GenreDTO;
import com.task_management.taskmanagement.entity.Genre;
import com.task_management.taskmanagement.exceptions.ResourceNotFoundException;
import com.task_management.taskmanagement.mapper.GenreMapper;
import com.task_management.taskmanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreMapper.INSTANCE::toGenreDTO)
                .collect(Collectors.toList());
    }

    public GenreDTO getGenreById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + id));
        return GenreMapper.INSTANCE.toGenreDTO(genre);
    }

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = GenreMapper.INSTANCE.toGenre(genreDTO);
        genre = genreRepository.save(genre);
        return GenreMapper.INSTANCE.toGenreDTO(genre);
    }

    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + id));
        genre.setName(genreDTO.getName());
        genre = genreRepository.save(genre);
        return GenreMapper.INSTANCE.toGenreDTO(genre);
    }

    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + id));
        genreRepository.delete(genre);
    }
}
