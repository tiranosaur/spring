package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("test-view")
    public String testView() {
        return "test";
    }

    @GetMapping("test-rest")
    @ResponseBody
    public String testRest() {
        return "{\"test\":\"rest controller\"}";
    }
}
