package rs.ac.bg.fon.notificationservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rs.ac.bg.fon.notificationservice.model.Task;

@FeignClient(name = "taskservice", url = "localhost:8080")
public interface TaskServiceClient {

    @GetMapping("/api/tasks/{id}")
    Task getTaskById(@PathVariable("id") Long id);
}
