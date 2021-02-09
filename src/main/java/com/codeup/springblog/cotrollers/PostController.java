package com.codeup.springblog.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String post() {
        return "Posts Index Page";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postById(@PathVariable int id) {
        return "View individual post " + id;
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String viewFrom() {
        return "View the form for creating post";
    }


    @PostMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "Create a new posts";
    }




}
