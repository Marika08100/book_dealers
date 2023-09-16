package hu.progmatic.book_dealers;

import hu.progmatic.book_dealers.model.Book;
import hu.progmatic.book_dealers.model.User;
import hu.progmatic.book_dealers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @GetMapping("/addUser")
    public String showAddUser(Model model) {
        model.addAttribute("newUser", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("addUser") User newUser) {
        userService.addUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/randomUser")
    public String getRandomUser(Model model) {
        model.addAttribute("randomUser", userService.getRandomUser());
        return "randomUser";
    }

}
