package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Creating first get request in spring
@Controller
public class LectureHelloController {
    @GetMapping("/hello")
    @ResponseBody
            public String hello(){
        return "Hello from Spring";
    }

//    Using a path variable

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }


//    @RequestMapping(path = "/imcrement")      With a request mapping you can specify either a get or a post

@RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
@ResponseBody
public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) +"!";
}
}
