package com.library.management.mappers;

import com.library.management.dto.RentalDTO;
import com.library.management.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    @Mapping(source = "book.id", target = "bookId")
    RentalDTO toDTO(Rental rental);

    @Mapping(source = "bookId", target = "book.id")
    Rental toEntity(RentalDTO rentalDTO);
}
