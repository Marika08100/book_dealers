package service;

import model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    List<Book> bookList = new ArrayList<>();

    public BookService() {
        bookList.add(new Book("The Lord of The Rings", "J. R. R. Tolkien"));
    }


    public List<Book> printBooks() {
        return bookList;
    }

    public void addBook(Book book) {
         bookList.add(book);
    }
    public void removeBook(Book book){
        bookList.remove(book);
    }
}

