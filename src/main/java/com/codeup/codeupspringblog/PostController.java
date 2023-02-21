package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GET("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }
}
