package hu.progmatic.book_dealers.service;

import hu.progmatic.book_dealers.model.Book;
import hu.progmatic.book_dealers.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final Random random;

    public UserService(Random random) {
        this.random = random;
        users.add(new User("Mary", "ambrusmarika02@gmail.com"));
    }
    public List<User> getAllUser(){
        return users;

    }
    public void adduser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public User getRandomUser() {
        return users.get(random.nextInt(users.size()));
    }
}
