package rs.ac.bg.fon.notificationservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rs.ac.bg.fon.notificationservice.model.User;

@FeignClient(name = "user-service", url = "localhost:8081")
public interface UserServiceClient {

    @GetMapping("/api/users/{id}")
    User getUserById(@PathVariable("id") Long id);
}
