package com.library.management.mappers;

import com.library.management.dto.BookDTO;
import com.library.management.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    BookDTO toDTO(Book book);

    @Mapping(source = "authorId", target = "author.id")
    Book toEntity(BookDTO bookDTO);
}
