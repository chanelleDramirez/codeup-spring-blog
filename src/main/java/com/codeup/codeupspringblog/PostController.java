package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String id() {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }
}
