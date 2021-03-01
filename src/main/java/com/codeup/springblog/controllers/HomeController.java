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

//    @GetMapping("/")
//
//
//    public String main(){
//        return "home";
//    }    @GetMapping("/login")
//    public String showLoginForm(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String viewUserProfile(Model model, Post post, @PathVariable Long id) {
//
//
//        User user = userService.getLoggedInUser();
//        List<Post> usersPosts = (postsDao.findAllById(user.getId()));
//
//
//
//        model.addAttribute("user", user.getUsername());
//        model.addAttribute("posts", usersPosts);
//        return "redirect:/user";
//    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

//    @PostMapping("/login")
//    public String viewUserProfile(Model model, Post post, @PathVariable Long id) {
//
//
//        User user = userService.getLoggedInUser();
//        List<Post> usersPosts = (postsDao.findAllById());
//
//
//
//        model.addAttribute("user", user.getUsername());
//        model.addAttribute("posts", usersPosts);
//        return "redirect:/user";
//    }





//    @PostMapping("/user")
//    public String showUserProfile(@ModelAttribute Model model ){
//        User user = userService.getLoggedInUser();
//        model.addAttribute("user", user);
//        return"user";
//    }


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
        EasyRandom generator = new EasyRandom();
        List<Post> posts = generator.objects(Post.class, 3).collect(Collectors.toList());
        model.addAttribute("posts", posts);

//        List<Post> posts = new ArrayList<>();
//        posts.add(postsDao.getOne(1l));
//        posts.add(postsDao.getOne(2l));
//        posts.add(postsDao.getOne(3l));

//        model.addAttribute("posts", posts);
        return "home";

    }



}
