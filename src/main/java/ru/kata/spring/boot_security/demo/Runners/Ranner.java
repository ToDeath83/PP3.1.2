package ru.kata.spring.boot_security.demo.Runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Repository.UserRepository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Set;

@Component
public class Ranner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        User user = new User("Admin","Adminov", 100,
                "admin", "$2a$12$tXFFNQtKIPK9rmJtDLFAgutV2TH6MiFba2Qa1IgotgKH1xLmeKa8a", Set.of(roleUser, roleAdmin));
        if (userRepository.findByUsername("admin") == null) {
            userRepository.save(user);
        }
    }
}
