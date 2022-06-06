package com.savin.controller;

import com.savin.dto.books.BooksDTO;
import com.savin.dto.books.BooksPriceAndCountOnly;
import com.savin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {
    private BookService bookService;

    @Autowired
    private BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BooksDTO searchByIdBook(@PathVariable(value = "id") long id){
        return bookService.getByIdBook(id);
    }

    @GetMapping("/all")
    public List<BooksDTO> getBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public BooksDTO addBook(@RequestBody BooksDTO booksDTO){
        return bookService.saveBook(booksDTO);
    }

    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullBook(@PathVariable(value = "id") long id,
                                         @RequestBody BooksDTO booksDTO){
        return bookService.updateFullBook(id, booksDTO);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable(value = "id") long id,
                                     @RequestBody BooksPriceAndCountOnly booksPriceAndCountOnly){
        return bookService.updateBook(id, booksPriceAndCountOnly);
    }

    @DeleteMapping("/del/{id}")
    public String deleteBook(@PathVariable(value = "id") long id){
        return bookService.deleteBook(id);
    }


}
