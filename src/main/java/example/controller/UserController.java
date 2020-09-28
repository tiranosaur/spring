package example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public String get(
            @RequestParam(name = "id", required = false, defaultValue = "0") Integer userId
    ) throws JsonProcessingException {
        if (userId > 0) {
            return (new ObjectMapper()).writeValueAsString(userService.getUserById(userId));
        } else {
            return (new ObjectMapper()).writeValueAsString(userService.getUsers());
        }
    }
}
