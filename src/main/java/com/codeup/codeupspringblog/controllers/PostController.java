package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.Repository.PostRepository;
import com.codeup.codeupspringblog.Repository.UserRepository;
import com.codeup.codeupspringblog.Services.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;


@Controller
public class PostController {  // lines 16 to  29 is how you use dependency injection.


    private final UserRepository userDao;
    private final PostRepository postDao;
private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }




   // private final EmailService emailDao;


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
    public String create(Model model) { // code has been refactored to implement form model binding
        model.addAttribute("posts", new Post());
        return "posts/create";
    }
@PostMapping("/posts/create")
    public String createProduce(@ModelAttribute Post posts){ // code has been refactored to implement form model binding
//public String createProduce(@RequestParam(name = "title") String title, @RequestParam(name="body") String body ) {
//    Post post = new Post (title, body);
    postDao.save(posts);

    return "redirect:/posts";
}

@PostMapping("/posts/save") // assigning a user to a post
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.findById(1);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post);
        return "redirect:/posts";
}

@GetMapping("/posts/{id}/edit") // Form Model Binding exercise
    public String editPostForm(Model model, @PathVariable long id){
model.addAttribute("post",postDao.findPostById(id));
    model.addAttribute("heading", "Edit Post");
    return "/posts/create";
}


}


