package com.library.management.controller;

import com.library.management.dto.RentalDTO;
import com.library.management.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/book/{bookId}")
    public List<RentalDTO> getRentalsByBookId(@PathVariable Long bookId) {
        return rentalService.findRentalsByBookId(bookId);
    }

    @PostMapping
    public RentalDTO createRental(@RequestBody RentalDTO rentalDTO) {
        return rentalService.saveRental(rentalDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        if (rentalService.findRentalsByBookId(id).isEmpty()) {
            rentalService.deleteRentalById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}