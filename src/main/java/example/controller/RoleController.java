package example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("role")
    @ResponseBody
    public String get(
            @RequestParam(name = "id", required = false, defaultValue = "0") Integer roleId
    ) throws JsonProcessingException {
        if (roleId == 0) {
            return (new ObjectMapper()).writeValueAsString(roleService.all());
        } else {
            return (new ObjectMapper()).writeValueAsString(roleService.get(roleId));
        }
    }
}
