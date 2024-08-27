package com.library.management.service;

import com.library.management.dto.RentalDTO;
import com.library.management.entity.Rental;
import com.library.management.mappers.RentalMapper;
import com.library.management.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public List<RentalDTO> findRentalsByBookId(final Long bookId) {
        return rentalRepository.findByBookId(bookId).stream()
                .map(rentalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RentalDTO saveRental(final RentalDTO rentalDTO) {
        Rental rental = rentalMapper.toEntity(rentalDTO);
        return rentalMapper.toDTO(rentalRepository.save(rental));
    }

    public void deleteRentalById(final Long id) {
        rentalRepository.deleteById(id);
    }
}