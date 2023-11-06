package sandoval.john.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.dojosandninjas.models.Dojo;
import sandoval.john.dojosandninjas.services.DojoService;

@RestController
public class DojoApiController {

    // Inject Dojo service into the API controller
    private DojoService dojoService;

    // Constructor for the API controller with the Dojo service
    public DojoApiController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    // Handle GET request to retrieve all dojos from the database
    @GetMapping("/api/dojos")
    public List<Dojo> getAllDojos() {
        return dojoService.findAllDojos();
    }

    // Handle GET request to retrieve a dojo from the database using the PathVariable
    @GetMapping("/api/dojos/{id}")
    public Dojo getDojoById(@PathVariable long id) {
        return dojoService.findDojoById(id);
    }

    // Handle POST request to save a dojo to the database
    @PostMapping("/api/dojos")
    public Dojo saveDojo(@RequestBody Dojo dojo) {
        return dojoService.createDojo(dojo);
    }
}
