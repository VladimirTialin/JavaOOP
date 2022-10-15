package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository useRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.useRepository = userRepository;
        this.useRepository.save(new User("Спасибо"));
        this.useRepository.save(new User("Вам"));
        this.useRepository.save(new User("большое"));
        this.useRepository.save(new User("за"));
        this.useRepository.save(new User("семинары!"));
    }
    public List<User> findAll() {
        return useRepository.findAll();
    }
    public Optional<User> findById(long id){
        return useRepository.findById(id);
    }
}