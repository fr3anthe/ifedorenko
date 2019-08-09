package ru.job4j.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Constants;
import ru.job4j.model.entities.User;
import ru.job4j.service.AccountService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class AccountController {
    private final AccountService as;

    /**
     * Constructor.
     * @param as AccountService
     */
    @Autowired
    public AccountController(AccountService as) {
        this.as = as;
    }

    /**
     * Getting page login.
     * @return jsp
     */
    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    /**
     * Getting page registration.
     * @return jsp
     */
    @GetMapping("registration")
    public String showRegistration() {
        return "registration";
    }

    /**
     * Exit process.
     * @param session user's session
     * @return jsp
     */
    @GetMapping("exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:../account/login.do";
    }

    /**
     * User authentication process.
     * @param user user
     * @param model model
     * @param session HttpSession
     * @return jsp
     */
    @PostMapping("login")
    public String authentications(@ModelAttribute User user, ModelMap model, HttpSession session) {
        String result;
        if (as.isUserCredential(user)) {
            session.setAttribute(Constants.USER, user);
            result = "redirect:../ad/listAd.do";
        } else {
            model.addAttribute(Constants.ERROR, "credentional invalid");
            result = "login";
        }
        return result;
    }

    /**
     * User registration process.
     * @param user user
     * @param model model
     * @return jsp
     */
    @PostMapping("registration")
    public String registration(@ModelAttribute User user, ModelMap model) {
        String result;
        if (as.isUserExist(user)) {
            as.addUser(user);
            result = "redirect:login.do";
        } else {
            model.addAttribute(Constants.ERROR, "user already exist");
            result = "registration";
        }
        return result;
    }

}
