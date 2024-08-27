package com.library.management.mappers;

import com.library.management.dto.AuthorDTO;
import com.library.management.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    Author toEntity(AuthorDTO authorDTO);
}
