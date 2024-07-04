package com.task_management.taskmanagement.mapper;

import com.task_management.taskmanagement.dto.GenreDTO;
import com.task_management.taskmanagement.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO toGenreDTO(Genre genre);

    Genre toGenre(GenreDTO genreDTO);
}
