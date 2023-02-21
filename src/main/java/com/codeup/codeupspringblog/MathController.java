package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path ="/add/{number3}/and/{number4}", method = RequestMethod.GET)
    @ResponseBody
    public String addThreeAndFour(@PathVariable int number3, @PathVariable int number4){
        return String.format("%d plus %d = %d", number3, number4, number3 + number4);
    }

    @RequestMapping(path ="/subtract/{number3}/from/{number10}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractThreeFromTen(@PathVariable int number10, @PathVariable int number3){
        return String.format("%d from %d = %d", number3, number10, number10 - number3);
    }

    @RequestMapping(path ="/multiply/{number4}/by/{number5}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyFourAndFive(@PathVariable int number4, @PathVariable int number5){
        return String.format("%d by %d = %d", number4, number5, number4 * number5);
    }

    @RequestMapping(path ="/divide/{number6}/by/{number3}", method = RequestMethod.GET)
    @ResponseBody
    public String divideSixByThree(@PathVariable int number6, @PathVariable int number3){
        return String.format("%d by %d = %d", number6, number3, number6 / number3);
    }
}
