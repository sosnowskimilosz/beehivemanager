package milosz.spring01.controller;

import milosz.spring01.model.User;
import milosz.spring01.security.PasswordConfig;
import milosz.spring01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registry")
    public String getRegistryPage(Model model){
        model.addAttribute("user",new User());
        return "registry";
    }

    @GetMapping("/registry_with_error")
    public String getRegistryErrorPage(Model model){
        model.addAttribute("user",new User());
        return "registry_with_error";
    }

    @PostMapping("/registry/users")
    public String registerNewUser(@Valid User user){
        if (userService.isUserNameExists(user.getUsername())){
            return "redirect:/registry_with_error";
        }
        userService.addUser(user);
        logger.info("New user is added to repo -> {}",user);
        return "redirect:/registry/view/success";
    }

    @GetMapping("/registry/view/success")
    public String viewRegistrySucceededPage() {
        return "registry_succeeded";
    }
}
