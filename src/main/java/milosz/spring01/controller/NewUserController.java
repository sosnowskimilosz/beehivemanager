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

//I would use simpler name - UserController
@Controller
public class NewUserController {

    UserRepository repository;

    Logger logger= LoggerFactory.getLogger(NewUserController.class);

    //Starting from Spring 4.2.3 you don't need to add @Autowired annotation
    //Please look at https://javappa.com/kurs-spring/wstrzykiwanie-zaleznosci
    //However you should use service where you inject repository (and avoid repository injection in controller)
    @Autowired
    public NewUserController(UserRepository repository) {
        this.repository = repository;
    }

    //You should map this url using resource name so simply -> /registry
    @GetMapping("/register")
    public String getRegistryPage(Model model){
        model.addAttribute("user",new User());
        return "registry";
    }

    //Current best practice is to use camelCase convention: registerUser
    //Hovewer it would be better to use simply resource name in the plural name
    //simply -> /users
    //please look at https://javappa.com/kurs-aplikacji-web/starter
    @PostMapping("/register_user")
    public String registerNewUser(@Valid User user){
        //This should be put in a separated security class
        PasswordConfig encoder = new PasswordConfig();
        String encodedPassword = encoder.passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
        logger.info("New user is added to repo -> {}",user);
        return "redirect:/registry_succeeded";
    }

    //How about: /registry/view/succes
    @GetMapping("/registry_succeeded")
    public String viewRegistrySucceededPage() {
        return "registry_succeeded";
    }
}
