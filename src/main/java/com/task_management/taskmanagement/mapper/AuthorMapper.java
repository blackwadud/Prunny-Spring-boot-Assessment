package com.task_management.taskmanagement.mapper;

import com.task_management.taskmanagement.dto.AuthorDTO;
import com.task_management.taskmanagement.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toAuthorDTO(Author author);

    Author toAuthor(AuthorDTO authorDTO);
}
