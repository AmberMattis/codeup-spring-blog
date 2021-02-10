package com.codeup.springblog.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String displayMessage(){
        return "roll-dice";
    }
}
