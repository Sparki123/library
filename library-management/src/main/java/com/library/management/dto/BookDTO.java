package com.library.management.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookDTO {
    private Long id;

    private String title;

    private LocalDate publishedDate;

    private Long authorId;
}
