package com.upc.boundservice.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.upc.boundservice.exception.ResourceNotFoundException;
import com.upc.boundservice.models.Book;
import com.upc.boundservice.repositories.IBookRepository;
import com.upc.boundservice.resources.communitacions.BaseResponse;
import com.upc.boundservice.resources.inputs.BookOutput;
import com.upc.boundservice.resources.outputs.BookInput;
import com.upc.boundservice.services.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{

  @Autowired
  private IBookRepository bookRepository;

  @Override
  public Book save(Book t) throws Exception {
    return bookRepository.save(t);
  }

  @Override
  public void deleteById(Integer id) throws Exception {
    bookRepository.deleteById(id);
    
  }

  @Override
  public Optional<Book> findById(Integer id) throws Exception {
    return bookRepository.findById(id);
  }

  @Override
  public List<Book> findAll() throws Exception {
    return bookRepository.findAll();
  }


  @Override
  public BaseResponse updateBookById(Integer bookId, BookInput bookInput) {
    BaseResponse response = new BaseResponse();
    try {
      Book getBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Books", "id", bookId));
      getBook.setName(bookInput.getName());
      getBook.setAuthor(bookInput.getAuthor());
      getBook.setPages(bookInput.getPages());
  
      response = new BaseResponse("updateBookById","success",1);
      response.setBookOutput(toBookOutput(getBook));
      return response;
    } catch (Exception e){
      return new BaseResponse("updateBookById", "An error ocurred while getting the book: "+e.getMessage(),-2);
    }
  }

  @Override
  public BaseResponse deleteBookById(Integer bookId) {
    BaseResponse response = new BaseResponse();
    try{
      Book getBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Books", "id", bookId));
      bookRepository.deleteById(bookId);
      response = new BaseResponse("deleteBookById","success",1);
      response.setBookOutput(toBookOutput(getBook));
      return response;
    }catch(Exception e){
      return new BaseResponse("deleteBookById", "An error ocurred while getting the book: "+e.getMessage(),-2);

    }

  }

  @Override
  public BaseResponse insertBook(BookInput bookInput) {
    BaseResponse response = new BaseResponse();
    try {
      Book newBook = new Book();
      newBook.setAuthor(bookInput.getAuthor());
      newBook.setName(bookInput.getName());
      newBook.setPages(bookInput.getPages());

      newBook = bookRepository.save(newBook);
      response = new BaseResponse("insertBook","success",1);
      response.setBookOutput(toBookOutput(newBook));
      return response;
    } catch (Exception e) {
      return new BaseResponse("insertBook", "An error ocurred while getting the book: "+e.getMessage(),-2);
    }
  }

  @Override
  public BaseResponse findBookById(Integer bookId) {
    BaseResponse response = new BaseResponse();
    try {
      Book getBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Books", "id", bookId));
      response = new BaseResponse("findBookById","success",1);
      response.setBookOutput(toBookOutput(getBook));
      return response;
    } catch(Exception e){
      return new BaseResponse("findBookById", "An error ocurred while getting the book: "+e.getMessage(),-2);
    }
  }

  @Override
  public BaseResponse findAllBooks() {
    BaseResponse response = new BaseResponse();
    try {
      List<Book> getBooks = bookRepository.findAll();
      List<BookOutput> bookOutputList = new ArrayList<>();
      for (Book b: getBooks)
      {
        bookOutputList.add(toBookOutput(b));
      }
      response = new BaseResponse("findAllBooks","success",1);
      response.setBookOutputList(bookOutputList);
      return response;
    } catch (Exception e) {
      return new BaseResponse("findAllBooks", "An error ocurred while getting the book: "+e.getMessage(),-2);
    }
  }

  public BookOutput toBookOutput(Book getBook) {
    BookOutput bookOutput = new BookOutput();
    bookOutput.setId(getBook.getId());
    bookOutput.setName(getBook.getName());
    bookOutput.setAuthor(getBook.getAuthor());
    bookOutput.setPages(getBook.getPages());
    return bookOutput;
  }
}
