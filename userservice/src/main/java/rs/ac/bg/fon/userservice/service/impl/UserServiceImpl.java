package rs.ac.bg.fon.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.userservice.exception.UserNotFoundException;
import rs.ac.bg.fon.userservice.model.User;
import rs.ac.bg.fon.userservice.repository.UserRepository;
import rs.ac.bg.fon.userservice.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()){
            throw new UserNotFoundException("User with id = "+id+" not found.");
        }
        return result.get();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
