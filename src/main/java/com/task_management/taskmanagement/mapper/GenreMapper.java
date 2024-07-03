package com.example.bookstore.mapper;

import com.example.bookstore.dto.GenreDTO;
import com.example.bookstore.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO toGenreDTO(Genre genre);

    Genre toGenre(GenreDTO genreDTO);
}
