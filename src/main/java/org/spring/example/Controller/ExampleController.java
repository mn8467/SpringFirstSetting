package org.spring.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleController {

    @RequestMapping(value = "/example.do", method = RequestMethod.GET)
    public String ExampleMain() {
        return "example";
    }
}