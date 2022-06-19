package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.Repository.UserRepository;
import ru.kata.spring.boot_security.demo.models.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
//
//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        //return entityManager.createQuery("from User ", User.class).getResultList();
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        //entityManager.persist(user);
        userRepository.save(user);
    }

    @Override
    public User readUser(Long id) {
        //return entityManager.find(User.class, id);
        return userRepository.getReferenceById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        User user = readUser(id);
//        entityManager.remove(user);
//        entityManager.flush();
        userRepository.delete(user);
    }
}