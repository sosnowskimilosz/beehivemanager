package milosz.spring01.controller;

import milosz.spring01.service.BeehiveService;
import milosz.spring01.model.BeehiveMark;
import milosz.spring01.model.Beehive;
import milosz.spring01.model.BeehiveType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
public class BeehiveController {

    @Autowired
    BeehiveService beehiveService;

    Logger log= LoggerFactory.getLogger(BeehiveController.class);

    public BeehiveController(BeehiveService beehiveService) {
        this.beehiveService = beehiveService;
    }

    @ModelAttribute("allTypes")
    public List<BeehiveType> populateTypes() {
        return Arrays.asList(BeehiveType.values());
    }

    @ModelAttribute("allMarks")
    public List<BeehiveMark> marks() {
        return Arrays.asList(BeehiveMark.values());
    }

    @GetMapping("/beehive")
    public String viewHomePage(Model model) {

        return findPaginated(1,model);
    }

    @GetMapping("/beehive/delete-by-id/{id}")
    public String deleteById(@PathVariable Integer id) {
        beehiveService.deleteBeehive(id);
        return "redirect:/beehive";
    }

    @GetMapping("/beehive/signup")
    public String showSignUpForm(Beehive beehive) {
        return "add_beehive";
    }

    @PostMapping("/beehive/addnew")
    public String addNewBeehive(@Valid Beehive beehive, BindingResult result) {
        if (result.hasErrors()) {
            return "add_beehive";
        }
        beehiveService.addBeehive(beehive);
        return "redirect:/beehive";
    }

    @GetMapping("/beehive/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Beehive beehive = beehiveService.getBeehiveWithId(id);
        log.info("Beehive from repository -> {}",beehive);
        model.addAttribute("beehiveID", beehive.getId());
        model.addAttribute("beehive", beehive);
        return "update_beehive";
    }

    @GetMapping("/beehive/update/{id}")
    public String updateBeehiveWithId(@Valid Beehive beehive, BindingResult result, @PathVariable("id") Integer id) {
        if (result.hasErrors()) {
            return "update_beehive";
        }
        beehiveService.updateBeehive(beehive);
        log.info("Update beehive succeed -> {}",beehive);
        return "redirect:/beehive";
    }

    @GetMapping("beehive/page/{pageNo}")
    public String findPaginated(@PathVariable (value="pageNo") int pageNo, Model model){
        int pageSize = 5;
        Page<Beehive> page = beehiveService.findPaginate(pageNo,pageSize);
        List<Beehive> beehives=page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("allBeehives",beehives);
        return "show_beehives";
    }
}
