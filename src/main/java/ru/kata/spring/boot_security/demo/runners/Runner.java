package ru.kata.spring.boot_security.demo.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Repository.UserRepository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Set;

@Component
public class Runner implements ApplicationRunner {

    private final UserRepository userRepository;

    public Runner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        User user = new User("Admin", "Adminov", 100
                ,"admin", "$2a$12$/.C3WdXUSwCKObISXT7DXutoGBwxdl9r89GZ/e6/mCy.iJM4PTzlK", Set.of(adminRole, userRole));
        if(userRepository.findByUsername("admin") == null){
            userRepository.save(user);
        }
    }
}
