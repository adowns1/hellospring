package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})

public class HelloController {

//responds to hello?name=LaunchCode
    @GetMapping
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " +name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

// responds to hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        String greeting = "Hello, " +name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //returns form from html file
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Ashley");
        names.add("Kathryn");
        names.add("Downs");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
