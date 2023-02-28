package com.codeup.codeupspringblog;


import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        ArrayList<String> content = new  ArrayList<String>();
        content.add("first");
        content.add("second");
        content.add("third");
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String id(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "posts/create";
    }
@PostMapping("/posts/create")
public String createProduce(@RequestParam(name = "produce") String produce, Model model) {
        model.addAttribute("produce", "Welcome to " + produce + "!");
        return "/posts/create";
}

}
