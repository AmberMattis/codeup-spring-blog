package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numberOne, @PathVariable int numberTwo){
        return "The sum of " + numberOne + " and " +  numberTwo + " is " + (numberOne + numberTwo);
    }

    @RequestMapping(path = "/subtract/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numberOne, @PathVariable int numberTwo){
        return "The difference between " + numberOne + " and " +  numberTwo + " is " + (numberOne - numberTwo);
    }

    @RequestMapping(path = "/multiply/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo){
        return "The product of " + numberOne + " and " +  numberTwo + " is " + (numberOne * numberTwo);
    }

    @RequestMapping(path = "/divide/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String didvide(@PathVariable int numberOne, @PathVariable int numberTwo){
        return "The quotient of " + numberOne + " and " +  numberTwo + " is " + (numberOne / numberTwo);
    }







}
