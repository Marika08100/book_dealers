import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import hu.progmatic.book_dealers.service.BookService;

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
}
