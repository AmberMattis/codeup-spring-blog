package com.codeup.springblog.cotrollers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    @GetMapping("/posts")
    public String post(Model model) {
        Post post1 = new Post("My first post", "This is my first post", 1L);
        Post post2 = new Post("My second post","This is my second post", 2L);
        Post post3 = new Post("My third post", "This is my third post", 2L);

        List<Post> allPosts = new ArrayList<>();
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);

        model.addAttribute("title", "All Posts");
        model.addAttribute("posts", allPosts);

        return "posts/index";
    }




    @GetMapping("/posts/{id}")
    public String postById(Model model) {
        Post post1 = new Post("My first post", "This is my first post", 1L);
        model.addAttribute("title", "Specific Post");
        model.addAttribute("post", post1);
        return "posts/show";
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
