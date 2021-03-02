package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    // Added the properties that will be implemented in the methods below,
// These give access to the post and use repository and the email service class
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;
    private final UserService userService;

    //    Added the PostController constructor. When a property is final it
//    must be added to a constructor for dependency injection
    public PostController(PostRepository postDao, UserRepository usersDao, EmailService emailService, UserService userService) {
        this.postsDao = postDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
        this.userService = userService;
    }


    //    This method displays all of the blog posts in the dataase.
//    The model object allows the contents in the database to be displayed in the
//    related view using the model.addAttribute() method
    @GetMapping("/posts")
    public String showPosts(Model model) {

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
    public String viewFromCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createForm(@ModelAttribute Post post) {

        User user = userService.getLoggedInUser();

        post.setUser(user);
        Post savedPost = postsDao.save(post);

        String subject = "New Blog Created!";
        String body = "Hi " + savedPost.getUser().getUsername() + " You have created a new blog: "
                + savedPost.getTitle() + "." + " Your post id is "
                + savedPost.getId();

        emailService.prepareAndSend(savedPost, subject, body);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {

        User user = userService.getLoggedInUser();
        User usersPost = post.getUser();

        if (usersPost.getId() == user.getId()) {
            postsDao.save(post);
        }
        return "redirect:/posts";

    }

    @PostMapping("/posts/{id}/delete")

    public String deletePost(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


    @GetMapping("/user")
    public String viewUserProfile(Model model)  {
        User user = userService.getLoggedInUser();

        List<Post> allPost = postsDao.findAll();
        List<Post> usersPost = new ArrayList<>();

        for(Post post : allPost) {
            if (post.getUser().getId() == user.getId()){
                usersPost.add(post);
            }
        }

        model.addAttribute("user", user.getUsername());
        model.addAttribute("posts", usersPost);

        return "user";
    }

}
