package milosz.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String viewHomePage() {
        return "index_beehive";
    }

    @GetMapping("/registration")
    public String viewRegistryPage() {
        return "registry";
    }

    @GetMapping("/login")
    public String viewLogInPage(Model model) {
        return "login";
    }
}
