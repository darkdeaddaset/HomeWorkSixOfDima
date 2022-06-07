package com.savin.repository;

import com.savin.dto.books.BooksNameAndPriceDTO;
import com.savin.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query(value = "SELECT DISTINCT new com.savin.dto.books.BooksNameAndPriceDTO(name ,price) FROM Books")
    List<BooksNameAndPriceDTO> getDifferentAllNameAndPrice();

    @Query(value = "SELECT new com.savin.dto.books.BooksNameAndPriceDTO(name, price) FROM Books WHERE name LIKE CONCAT('%', 'Windows', '%')  OR price > 20000")
    List<BooksNameAndPriceDTO> findBooks();
}