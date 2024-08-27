package com.library.management.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalDTO {
    private Long id;

    private Long bookId;

    private Long userId;

    private LocalDate rentalDate;

    private LocalDate returnDate;
}
