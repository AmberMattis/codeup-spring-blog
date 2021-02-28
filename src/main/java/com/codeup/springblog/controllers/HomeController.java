package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.jeasy.random.EasyRandom;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final UserRepository usersDao;
    private final PasswordEncoder encoder;
    private final PostRepository postsDao;

    public HomeController(UserRepository usersDao, PasswordEncoder encoder, PostRepository postsDao ){
        this.usersDao = usersDao;
        this.encoder = encoder;
        this.postsDao = postsDao;

    }

//    @GetMapping("/")
//
//
//    public String main(){
//        return "home";
//    }

    @GetMapping("/login")
    public String showLoginForm(){
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
//        EasyRandom generator = new EasyRandom();
//        List<Post> posts = generator.objects(Post.class, 3).collect(Collectors.toList());
//        model.addAttribute("posts", posts);

        List<Post> posts = new ArrayList<>();
        posts.add(postsDao.getOne(1l));
        posts.add(postsDao.getOne(2l));
        posts.add(postsDao.getOne(3l));

        model.addAttribute("posts", posts);
        return "home";

    }



}
