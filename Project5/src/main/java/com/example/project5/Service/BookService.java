package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private  final BookRepository bookRepository;
    private final StoreRepository storeRepository;


    //Get all Book
    public List<Book> getBook(){
        return bookRepository.findAll();
    }

    //Add new Book
    public void addBook(Book book){
        bookRepository.save(book);
    }

    //Update Book
    public boolean updateBook(Integer ID,Book book){
        Book oldBook=bookRepository.findBookById(ID);
        if(oldBook==null){
            return false;
        }
        oldBook.setName(book.getName());
        oldBook.setBookCount(book.getBookCount());
        oldBook.setGenre(book.getGenre());


        bookRepository.save(oldBook);
        return true;
    }
    //Delete Book
    public boolean deleteBook(Integer ID){
        Book oldBook=bookRepository.findBookById(ID);
        if(oldBook==null){
            return false;
        }
        bookRepository.delete(oldBook);
        return true;
    }

    //assign Store to book,one to many
    public void assignStoreToBook(Integer store_id,Integer book_id){
        Store store=storeRepository.findStoreById(store_id) ;
        Book book=bookRepository.findBookById(book_id);
        if(store==null||book==null){
            throw new ApiException("Wrong data ");
        }
        book.setStore(store);
        bookRepository.save(book);
    }
    //3-endpoint that takes bookId and return number of books available

    public Integer getNumberOfBook(Integer id){
        Book book=bookRepository.findBookById(id);
        if(book==null){
            throw new ApiException("Book Id Not Found");
        }
        return book.getBookCount();
    }

    //4-endpoint that takes a book name and return all book information

    public Book getBookInformation(String name){
        Book book=bookRepository.findBookByName(name);
        if(book==null){
            throw new ApiException("Book Name Not Found");
        }
        return book;
    }

//   5- endpoint that return all books under a specific genre

    public List<Book> getAllByGenre(String genre){
        List<Book>books=bookRepository.findAllByGenre(genre);
        if(books==null){
            throw new ApiException("Book Genre Not Found");
        }
        return books;

    }
}
