package hu.progmatic.book_dealers;

import hu.progmatic.book_dealers.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import hu.progmatic.book_dealers.service.BookService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PageController {
    private final BookService bookService;

    @Autowired
    public PageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("about")
    public String about() {
        return "about";

    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.printBooks());
        return "bookList";
    }
    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }
    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("newBook") Book newBook) {
        bookService.addBook(newBook);
        return "redirect:/books";
    }
}
