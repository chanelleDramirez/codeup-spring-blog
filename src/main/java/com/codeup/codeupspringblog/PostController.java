package com.codeup.codeupspringblog;


import Repository.PostRepository;
import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class PostController {  // lines 14,16,18,and 19 is how you use dependency injection.

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsContent(Model model) {
        ArrayList<String> content = new  ArrayList<String>();
        content.add("first");
        content.add("second");
        content.add("third");
        model.addAttribute("content", content);
        return "posts/index";
    }

    @GetMapping("/posts/{id}") // type in a number in the browser instead of {id}
    public String id(@PathVariable long id, Model model) {
        Post post = (Post) postDao.findAllById(Collections.singleton(id)); // Collections.singleton had to be implemented to remove the error from id.
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create") // This is where the form for creating a post would go
    public String create() {
        return "posts/create";
    }
@PostMapping("/posts/create")
public String createProduce(@RequestParam(name = "title") String title, @RequestParam(name="body") String body ) {
    Post post = new Post (title, body);
    postDao.save(post);

    return "redirect:/posts";
}
}


