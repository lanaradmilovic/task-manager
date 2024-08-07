package rs.ac.bg.fon.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.userservice.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
