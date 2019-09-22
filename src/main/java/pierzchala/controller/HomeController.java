package pierzchala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pierzchala.model.Spitter;

@Controller
@RequestMapping({"/","homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping("/form")
    public String showRegistrationForm(Model model){
        model.addAttribute("spitter",new Spitter());
        return "form";
    }
}
