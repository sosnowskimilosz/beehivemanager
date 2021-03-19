package milosz.spring01.controller;

import milosz.spring01.model.User;
import milosz.spring01.repository.UserRepository;
import milosz.spring01.security.PasswordConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NewUserController {

    UserRepository repository;

    Logger logger= LoggerFactory.getLogger(NewUserController.class);

    @Autowired
    public NewUserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/register")
    public String getRegistryPage(Model model){
        model.addAttribute("user",new User());
        return "registry";
    }

    @PostMapping("/register_user")
    public String registerNewUser(@Valid User user){
        PasswordConfig encoder = new PasswordConfig();
        String encodedPassword = encoder.passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
        logger.info("New user is added to repo -> {}",user);
        return "redirect:/registry_succeeded";
    }

    @GetMapping("/registry_succeeded")
    public String viewRegistrySucceededPage() {
        return "registry_succeeded";
    }
}
