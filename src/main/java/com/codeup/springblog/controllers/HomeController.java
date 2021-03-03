package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.UserService;
import org.jeasy.random.EasyRandom;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final UserRepository usersDao;
    private final PasswordEncoder encoder;
    private final PostRepository postsDao;
    private final UserService userService;

    public HomeController(UserRepository usersDao, PasswordEncoder encoder, PostRepository postsDao, UserService userService ){
        this.usersDao = usersDao;
        this.encoder = encoder;
        this.postsDao = postsDao;
        this.userService = userService;

    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String createUser(@ModelAttribute User user) {
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/")
    public String showFeaturedPosts(Model model){

        Random random = new Random();
        List<Post> allPosts = postsDao.findAll();
        List<Post> featuredPosts = new ArrayList<>();

        int numberOfElements = 3;

        for(int i = 0; i < numberOfElements; i++){
            int randomIndex = random.nextInt(allPosts.size());
            Post featuredPost = allPosts.get(randomIndex);
            allPosts.remove(randomIndex);
            featuredPosts.add(featuredPost);
        }

        model.addAttribute("posts", featuredPosts);
        return "home";

    }



}
