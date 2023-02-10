package com.example.project5.Controller;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;


    //Get all Book
    @GetMapping("/get")
    public ResponseEntity getBook(){
        List<Book> books=bookService.getBook();
        return ResponseEntity.status(200).body(books);
    }
    //Add new Book
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book ){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book Added");
    }
    //Update Book
    @PutMapping("/update/{ID}")
    public ResponseEntity updateBook(@PathVariable Integer ID,@Valid@RequestBody Book book){
        boolean isUpdate= bookService.updateBook(ID,book);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Book Updated");
        }
        throw new ApiException("Wrong Book Id");
    }
    //Delete Book
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteBook(@PathVariable Integer ID){
        boolean isDelete= bookService.deleteBook(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Book Deleted");
        }
        throw new ApiException("Wrong Book Id");
    }
    //assign Store to book,one to many
    @PutMapping("/{store_id}/book/{book_id}")
    public ResponseEntity assignStoreToBook(@PathVariable Integer store_id,@PathVariable Integer book_id){
        bookService.assignStoreToBook(store_id,book_id);
        return ResponseEntity.status(200).body("Assignment Don Successfully");
    }
    //3-endpoint that takes bookId and return number of books available
    @GetMapping("/number/{id}")
    public ResponseEntity getNumberOfBook(@PathVariable Integer id){
        Integer numberOfBooks= bookService.getNumberOfBook(id);
        return  ResponseEntity.status(400).body("Number Of Book is: "+numberOfBooks);
    }
    //4-endpoint that takes a book name and return all book information
    @GetMapping("/name/{name}")
    public ResponseEntity getBookInformation(@PathVariable String name){
        Book book=bookService.getBookInformation(name);
        return ResponseEntity.status(200).body(book);
    }

    // 5-endpoint that return all books under a specific genre

    @GetMapping("/genre/{genre}")
    public ResponseEntity getAllBooksByGenre(@PathVariable String genre ){
        List<Book>books=bookService.getAllByGenre(genre);
        return  ResponseEntity.status(200).body(books);
    }
}
