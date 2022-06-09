package com.savin.controller;

import com.savin.dto.books.BooksDTO;
import com.savin.dto.books.BooksNameAndPriceDTO;
import com.savin.dto.books.BooksPriceAndCountOnly;
import com.savin.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Получение книги по id")
    @GetMapping("/{id}")
    public BooksDTO searchByIdBook(@PathVariable(value = "id") long id){
        return bookService.getByIdBook(id);
    }

    @Operation(summary = "Получение всех книг")
    @GetMapping("/all")
    public List<BooksDTO> getBooks(){
        return bookService.getAllBooks();
    }

    @Operation(summary = "Добавление книги")
    @PostMapping("/add")
    public BooksDTO addBook(@RequestBody BooksDTO booksDTO){
        return bookService.saveBook(booksDTO);
    }

    @Operation(summary = "Полное обновление книги по id")
    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullBook(@PathVariable(value = "id") long id,
                                         @RequestBody BooksDTO booksDTO){
        return bookService.updateFullBook(id, booksDTO);
    }

    @Operation(summary = "Частичное обновление книги по id")
    @PatchMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable(value = "id") long id,
                                     @RequestBody BooksPriceAndCountOnly booksPriceAndCountOnly){
        return bookService.updateBook(id, booksPriceAndCountOnly);
    }

    @Operation(summary = "Удаление книги по id")
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") long id){
        return bookService.deleteBook(id);
    }

    @Operation(summary = "Получение всех книг с разными названиями и ценами")
    @GetMapping("/dif/all")
    public List<BooksNameAndPriceDTO> getDifferentAllNameAndPrice(){
        return bookService.getDifferentAllNameAndPrice();
    }

    @Operation(summary = "Получение книги, в которых встречается слово 'Windows' или стоящие более 20000 руб.")
    @GetMapping("find-book/{word}&{price}")
    public List<BooksNameAndPriceDTO> findBooks(@PathVariable(value = "word") String word, @PathVariable(value = "price") int price){
        return bookService.findBooks(word, price);
    }
}