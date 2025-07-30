package fs.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    // 原有 GET 接口
    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from backend!";
    }

    // 新增 POST 接口
    @PostMapping("/api/greet")
    public Map<String, String> greetUser(@RequestBody Map<String, String> body) {
        String name = body.getOrDefault("name", "陌生人");
        return Map.of("message", "Hello, " + name + "!");
    }
}