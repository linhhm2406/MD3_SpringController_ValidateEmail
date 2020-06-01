package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class ValidateController {
    String REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    Pattern pattern;
    Matcher matcher;

    @GetMapping("/main")
    public ModelAndView showMain(){
        ModelAndView modelAndView = new ModelAndView("showMain");
        return modelAndView;
    }

    public boolean isValid(String input){
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @PostMapping("/validate")
    public ModelAndView validateEmail(@RequestParam String inputEmail){
        String result = displayResult(inputEmail);
        ModelAndView modelAndView = new ModelAndView("/showMain");
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    private String displayResult(@RequestParam String inputEmail) {
        boolean isValid = isValid(inputEmail);
        String result = "";
        if (isValid){
            result = "valid";
        }else {
            result = "invalid";
        }
        return result;
    }
}
