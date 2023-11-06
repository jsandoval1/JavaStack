package sandoval.john.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sandoval.john.dojosandninjas.models.Ninja;
import sandoval.john.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    // Constructor to inject the NinjaRepository
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    // Find all Ninjas
    public List<Ninja> findAllNinjas() {
        return ninjaRepository.findAll();
    }
    
    // Find a single Ninja
    public Ninja findNinjaById(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        return optionalNinja.orElse(null);
    }
    
    // Create a new Ninja
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
