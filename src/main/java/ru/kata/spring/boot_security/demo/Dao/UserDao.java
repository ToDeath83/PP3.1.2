package ru.kata.spring.boot_security.demo.Dao;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void saveUser(User user);

    User readUser(Long id);

    User findByUsername(String username);

    void deleteUser(Long id);
}