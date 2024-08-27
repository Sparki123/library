package com.library.management.service;

import com.library.management.dto.BookDTO;
import com.library.management.entity.Author;
import com.library.management.entity.Book;
import com.library.management.mappers.AuthorMapper;
import com.library.management.mappers.BookMapper;
import com.library.management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final AuthorService authorService;

    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> findBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Author author = authorService.findAuthorById(bookDTO.getAuthorId())
                .map(authorMapper::toEntity)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = bookMapper.toEntity(bookDTO);
        book.setAuthor(author);
        return bookMapper.toDTO(bookRepository.save(book));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}