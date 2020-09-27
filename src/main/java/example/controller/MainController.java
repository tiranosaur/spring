package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping
    public String index(){
        return "view/index.html";
    }

    @GetMapping("test-view")
    public String testView(){
        return "view/test.html";
    }

    @GetMapping("test-rest")
    @ResponseBody
    public String testRest(){
        return "{\"test\":\"rest controller\"}";
    }
}
