package com.upc.boundservice.controllers;

import javax.xml.ws.Response;

import com.upc.boundservice.resources.communitacions.BaseResponse;
import com.upc.boundservice.resources.outputs.BookInput;
import com.upc.boundservice.services.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {
  
  @Autowired
  private IBookService bookservice;

  @GetMapping
  public ResponseEntity<BaseResponse> findAllBooks()
  {
    BaseResponse result = bookservice.findAllBooks();

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  @GetMapping("/{bookId}")
  public ResponseEntity<BaseResponse> findBookById(@PathVariable(value = "bookId")int bookId)
  {
    BaseResponse result = bookservice.findBookById(bookId);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<BaseResponse> registerBook(@RequestBody BookInput bookInput) throws Exception {
    BaseResponse result = bookservice.insertBook(bookInput);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<BaseResponse> updateBook(@PathVariable(value = "bookId")int bookId, @RequestBody BookInput bookInput) throws Exception {
    BaseResponse result = bookservice.updateBookById(bookId, bookInput);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<BaseResponse> deleteBook(@PathVariable(value = "bookId")int bookId) throws Exception {
    BaseResponse result = bookservice.deleteBookById(bookId);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
