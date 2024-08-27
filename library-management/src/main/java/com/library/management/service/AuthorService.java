package com.library.management.service;

import com.library.management.dto.AuthorDTO;
import com.library.management.entity.Author;
import com.library.management.mappers.AuthorMapper;
import com.library.management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorDTO> findAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AuthorDTO> findAuthorById(final Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDTO);
    }

    public AuthorDTO saveAuthor(final AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        return authorMapper.toDTO(authorRepository.save(author));
    }

    public void deleteAuthorById(final Long id) {
        authorRepository.deleteById(id);
    }
}