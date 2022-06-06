package com.savin.mapper;

import com.savin.dto.books.BooksDTO;
import com.savin.dto.books.BooksPriceAndCountOnly;
import com.savin.model.Books;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Books fromDTOToBooks(BooksDTO from);
    BooksDTO fromBooksToDTO(Books books);
    void updatePartial(BooksPriceAndCountOnly booksPriceAndCountOnly,
                       @MappingTarget Books books);
    @Mapping(target = "id", ignore = true)
    void updateFull(BooksDTO booksDTO, @MappingTarget Books books);
}