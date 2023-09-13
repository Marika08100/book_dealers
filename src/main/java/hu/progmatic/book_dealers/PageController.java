package hu.progmatic.book_dealers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.BookService;

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
}
