package com.task_management.taskmanagement.mapper;

import com.task_management.taskmanagement.dto.BookDTO;
import com.task_management.taskmanagement.dto.AuthorDTO;
import com.task_management.taskmanagement.dto.GenreDTO;
import com.task_management.taskmanagement.entity.Book;
import com.task_management.taskmanagement.entity.Author;
import com.task_management.taskmanagement.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "author.name", target = "author.name")
    @Mapping(source = "genre.id", target = "genre.id")
    @Mapping(source = "genre.name", target = "genre.name")
    BookDTO toBookDTO(Book book);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "genre.id", target = "genre.id")
    Book toBook(BookDTO bookDTO);
}
