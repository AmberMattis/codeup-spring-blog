package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    private final PostRepository postsDao;

    public PostController(PostRepository postDao) {
        this.postsDao = postDao;
    }




    @GetMapping("/posts")
    public String showPosts(Model model){

        model.addAttribute("title", "All Posts");
        model.addAttribute("posts", postsDao.findAll());

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
    public String viewFromCreate() {
        return "View the form for creating post";
    }


    @PostMapping("/posts/create")
    @ResponseBody
    public String createForm() {

        return "Create a new posts";
    }



//    @GetMapping("/posts/delete")
//    public String viewFormDelete(Model model){
//        model.addAttribute("post", postsDao.deleteById());
//        return "post/index";
//    }


//    @PostMapping("/posts/delete")
//    public String deleteForm(@ModelAttribute("post") Post post) {
//     postsDao.deleteById(post.getId());
//    return "posts/index";
//    }


    @PostMapping("/posts/delete")
    public String deleteForm(@ModelAttribute("delete") Post post, Model model) {

        postsDao.deleteById(post.getId());
        model.addAttribute("title", post.getTitle());
        return "posts/delete";
    }




    @GetMapping("/posts/edit")
    @ResponseBody
    public String viewFormEdit(){
        return "View form for editing a post";
    }

    @PostMapping("/posts/edit")
    @ResponseBody
    public String editForm(){
        return "Edit existing post";
    }









}
