package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private Long authorId;
    private Long genreId;
}
