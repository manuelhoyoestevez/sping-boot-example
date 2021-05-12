package com.example.springboot;

import com.example.springboot.api.BookApi;
import com.example.springboot.model.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController implements BookApi {

    @Override
    public ResponseEntity<String> addBook(BookDto book) {
        return ResponseEntity.ok(book.getTitle()+" is added");
    }

    @Override
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> bookList = new ArrayList<>();
        bookList.add(new BookDto()
                .title("Name of the Wind")
                .author("Patrick"));
        bookList.add(new BookDto()
                .title("Mistborn")
                .author("Brandon"));
        return ResponseEntity.ok(bookList);
    }
}
