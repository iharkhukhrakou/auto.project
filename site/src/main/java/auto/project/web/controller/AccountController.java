package auto.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/account/registration")
public class AccountController {


    @GetMapping
    public ModelAndView showRegistration() {
        return new ModelAndView("account/registration");
    }

    @GetMapping(value = "/successfully")
    public ModelAndView registerSuccessfully() {
        return new ModelAndView("account/registrationSuccessfully");
    }
}
