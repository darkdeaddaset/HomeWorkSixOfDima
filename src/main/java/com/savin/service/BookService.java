package com.savin.service;

import com.savin.dto.books.BooksDTO;
import com.savin.dto.books.BooksNameAndPriceDTO;
import com.savin.dto.books.BooksPriceAndCountOnly;
import com.savin.exception.ResourceNotFoundException;
import com.savin.mapper.BookMapper;
import com.savin.model.Books;
import com.savin.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BooksRepository booksRepository;
    private final BookMapper mapper;

    @Autowired
    public BookService(BooksRepository booksRepository, BookMapper mapper) {
        this.booksRepository = booksRepository;
        this.mapper = mapper;
    }
    public BooksDTO getByIdBook(long id){
        return booksRepository.findById(id)
                .map(mapper::fromBooksToDTO)
                .orElseThrow(() ->new ResourceNotFoundException("Not found book with id: " + id));
    }

    public List<BooksDTO> getAllBooks(){
        return booksRepository.findAll()
                .stream()
                .map(mapper::fromBooksToDTO)
                .collect(Collectors.toList());
    }
    public BooksDTO saveBook(BooksDTO booksDTO){
        return Optional.of(booksDTO)
                .map(mapper::fromDTOToBooks)
                .map(booksRepository::save)
                .map(mapper::fromBooksToDTO)
                .orElseThrow();
    }

    public ResponseEntity updateFullBook(long id, BooksDTO booksDTO){
        return booksRepository.findById(id)
                .map(update -> { mapper.updateFull(booksDTO, update);
                    booksRepository.save(update);

                    return new ResponseEntity("Изменения внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updateBook(long id, BooksPriceAndCountOnly booksPriceAndCountOnly){
        return booksRepository.findById(id)
                .map(updatePartial -> { mapper.updatePartial(booksPriceAndCountOnly, updatePartial);
                    booksRepository.save(updatePartial);

                    return new ResponseEntity("Изменения внескны", HttpStatus.OK);
                }).orElseThrow();
    }

    public String deleteBook(long id){
        Books books1 = booksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found book with id: " + id));
        booksRepository.deleteById(id);

        Books books = books1;
        return id + ".Книга удалена :" + books.getName();
    }

    public List<BooksNameAndPriceDTO> getDifferentAllNameAndPrice(){
        return booksRepository.getDifferentAllNameAndPrice();
    }

    public List<BooksNameAndPriceDTO> findBooks(){
        return booksRepository.findBooks();
    }

}