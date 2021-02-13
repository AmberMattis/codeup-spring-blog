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
    public String postById(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
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


    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id,  Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body, Model model){
        Post post = new Post(title, body,id);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }





//    @PostMapping("/posts/edit")
//    @ResponseBody
//    public String postUpdatedForm(@ModelAttribute("edit") Post post ){
//
//        return "return updated post";
//    }









}
