package rs.ac.bg.fon.userservice.service;

import rs.ac.bg.fon.userservice.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    User findById(Long id);
    User findByName(String name);
}
