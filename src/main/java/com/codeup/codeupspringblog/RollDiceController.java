package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "Dice";

    }

    @GetMapping("/roll-dice/{number}")
    public String numberChosen(@PathVariable int number, Model model) {
        model.addAttribute("number", number);  // Passing the random number chosen by the user.
        int randomNum = (int) (Math.random() * 6) + 1; // generating the result of the dice roll.
        model.addAttribute("randomNum", randomNum); // Passing the result of the dice roll to the view.
        return "DiceReturn";
    }
}