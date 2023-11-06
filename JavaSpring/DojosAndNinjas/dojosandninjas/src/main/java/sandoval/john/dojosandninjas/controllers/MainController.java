package sandoval.john.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sandoval.john.dojosandninjas.models.Dojo;
import sandoval.john.dojosandninjas.models.Ninja;
import sandoval.john.dojosandninjas.services.DojoService;
import sandoval.john.dojosandninjas.services.NinjaService;

@Controller
public class MainController {

    @Autowired
    private DojoService dojoService;

    @Autowired
    private NinjaService ninjaService;

    // Controller for the rendering hello world page
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Controller for the displaying of all Dojos
    @GetMapping("/dojos")
    public String getAllDojos(Model model) {
        List<Dojo> dojos = dojoService.findAllDojos();
        model.addAttribute("dojos", dojos);
        return "ViewAllDojos";
    }

    // Controller for the displaying of displaying a single Dojo aiong with their
    // ninjas
    @GetMapping("/dojos/{dojoId}")
    public String getSingleDojo(@PathVariable("dojoId") Long dojoId, Model model) {
        Dojo singleDojo = dojoService.findDojoById(dojoId);
        model.addAttribute("dojo", singleDojo);
        return "ViewSingleDojo";
    }

    // Controller for displaying the create new Dojo page, // * Get dojo creation
    // page
    @GetMapping("/dojos/new")
    public String createNewDojo(Model model) {
        model.addAttribute("dojo", new Dojo());
        model.addAttribute("ninjas", ninjaService.findAllNinjas());
        return "CreateNewDojo";
    }

    // Controller for the creation of a new Dojo, //? Post Dojo creation page
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute Dojo dojo) {
        dojoService.createDojo(dojo);
        return "redirect:/dojos";
    }

    // Controller for the displaying the create new Ninja page, // * Get ninja creation page
    @GetMapping("/ninjas/new")
    public String showCreateNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.findAllDojos();
        model.addAttribute("dojos", dojos);
        return "CreateNewNinja";
    }

    // Controller for the creation of a new Ninja, //? Post ninja creation page
    @PostMapping("/ninjas") //! I changed this from @"ninjas/new" because it might cause confision with the same Get Method
    public String createNinja(@ModelAttribute Ninja ninja) {
        ninjaService.createNinja(ninja);
        return "redirect:/dojos";
    }

}

