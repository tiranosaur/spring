package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("test-view")
    public String index(){
        return "view/test.html";
    }

    @GetMapping("test-rest")
    @ResponseBody
    public String index1(){
        return "test rest controller";
    }

}
