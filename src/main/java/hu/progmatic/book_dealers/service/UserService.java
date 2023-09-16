package hu.progmatic.book_dealers.service;

import hu.progmatic.book_dealers.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final Random randomGenerator;

    public UserService(Random random) {
        this.randomGenerator = random;

        users.add(new User("Mary", "ambrusmarika02@gmail.com"));
        users.add(new User("John", "john@example.com"));
        users.add(new User("Alice", "alice@example.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
    public User getUserById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public User getRandomUser() {
        return users.get(randomGenerator.nextInt(users.size()));
    }
}
