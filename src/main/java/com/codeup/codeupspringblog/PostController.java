package com.codeup.codeupspringblog;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
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
}
