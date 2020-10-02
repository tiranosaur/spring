package example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.model.Role;
import example.model.User;
import example.service.role.RoleService;
import example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("user")
    @ResponseBody
    public String create(@Autowired User user, @Autowired Role role) throws JsonProcessingException {
        user.addRole(role);
        Map<String, String> errorMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getEmail().length() == 0) errorMap.put("email", "required");
        if (user.getUsername().length() == 0) errorMap.put("username", "required");

        if (errorMap.size() == 0 && userService.create(user) != null) {
            resultMap.put("status", true);
            resultMap.put("user", user);
            return (new ObjectMapper().writeValueAsString(user));
        }

        resultMap.put("errors", errorMap);
        resultMap.put("status", false);
        resultMap.put("message", "something went wrong");
        return (new ObjectMapper()).writeValueAsString(resultMap);
    }

    @GetMapping("user")
    @ResponseBody
    public String get(
            @RequestParam(name = "id", required = false, defaultValue = "0") Integer userId
    ) throws JsonProcessingException {
        if (userId == 0) {
            return (new ObjectMapper()).writeValueAsString(userService.all());
        } else {
            return (new ObjectMapper()).writeValueAsString(userService.get(userId));
        }
    }

    @GetMapping("user/edit")
    public String edit(@RequestParam(name = "id", required = false, defaultValue = "0") Integer userId, Model model) {
        model.addAttribute("user", userService.get(userId));
        model.addAttribute("userId", userId);
        return "user/edit";
    }

    @PostMapping("user/update")
    @ResponseBody
    public String update(@Autowired User user) throws JsonProcessingException {
        user.setRoles(userService.get(user.getId()).getRoles());
        Map<String, String> errorMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        if (userService.update(user) != null) {
            resultMap.put("status", true);
            resultMap.put("user", user);
            return (new ObjectMapper().writeValueAsString(user));
        }

        resultMap.put("errors", errorMap);
        resultMap.put("status", false);
        resultMap.put("message", "something went wrong");
        return (new ObjectMapper()).writeValueAsString(resultMap);
    }

    @PostMapping("user/delete")
    @ResponseBody
    public String delete(
            @RequestParam(name = "id", required = false, defaultValue = "0") Integer userId
    ) throws JsonProcessingException {
        Map<String, Object> resultMap = new HashMap<>();
        if (userService.delete(userId)) {
            resultMap.put("status", true);
            resultMap.put("message", "user deleted successfully");
        } else {
            resultMap.put("status", false);
            resultMap.put("message", "something went wrong");
        }
        return (new ObjectMapper()).writeValueAsString(resultMap);
    }
}
