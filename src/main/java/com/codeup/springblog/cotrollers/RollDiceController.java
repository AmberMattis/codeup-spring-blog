package com.codeup.springblog.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String displayMessage(){
        return "roll-dice";
    }


    @GetMapping("roll-dice/{number}")
    public String selectOne(@PathVariable int number, Model model){
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + min;
        boolean numMatch = false;

        if(random == number){
            numMatch = true;
        }

        model.addAttribute("random", random);
        model.addAttribute("numMatch", numMatch);
        model.addAttribute("number", number);

        return "roll-dice-result";
    }

}
