package sandoval.john.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sandoval.john.dojosandninjas.models.Dojo;
import sandoval.john.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
    
    private DojoRepository dojoRepository;
    
    // Constructor to inject the DojoRepository
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    // Find all Dojos
    public List<Dojo> findAllDojos() {
        return dojoRepository.findAll();
    }

    // Find a single Dojo
    public Dojo findDojoById(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }

    // Create a new Dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
}
