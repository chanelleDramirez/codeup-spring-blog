package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Repository.UserRepository;
import com.codeup.codeupspringblog.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

//    @PostMapping("/register")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/login"; // this will re-direct the user back to the login page because we don't save passwords and this allows users to sign up not login.
//    }

    @GetMapping("/login")
    public String userLogin(){
        return "users/login";
    }
}


// in order to get the User you will need to use
//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//post.setUser(user); this is what you use for java

//thymeleaf will get you a user by doing this
// add this to your html : xmlns:th="http://www.thymeleaf.org"
//      xmlns:sec="http://www.thymeleaf.org/extras/spring-security"

// #authentication.principal on the profile.html will allow you to access the user information.