package com.upc.boundservice.services;

import com.upc.boundservice.models.Book;
import com.upc.boundservice.resources.communitacions.BaseResponse;
import com.upc.boundservice.resources.outputs.BookInput;
import org.springframework.stereotype.Service;

@Service
public interface IBookService extends ICrudService<Book> {
    BaseResponse insertBook(BookInput bookInput);
    BaseResponse findBookById(Integer bookId);
    BaseResponse findAllBooks();
    BaseResponse updateBookById(Integer bookId, BookInput bookInput);
    BaseResponse deleteBookById(Integer bookId);
}
