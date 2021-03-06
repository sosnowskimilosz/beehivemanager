package milosz.spring01.service;

import milosz.spring01.model.Beehive;
import milosz.spring01.repository.BeehiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeehiveService {

    @Autowired
    BeehiveRepository beehiveRepository;

    public BeehiveService(BeehiveRepository beehiveRepository) {
        this.beehiveRepository = beehiveRepository;
    }

    public void addBeehive(Beehive beehive) {
        beehiveRepository.save(beehive);
    }

    public void deleteBeehive(Integer id) {
        beehiveRepository.deleteById(id);
    }

    public List<Beehive> getAllBeehives() {
        return beehiveRepository.findAll();
    }

    public Beehive getBeehiveWithId(Integer id) {
        return beehiveRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("\n\nInvalid user Id:" + id + "\n"));
    }

    public void updateBeehive(Beehive beehive) {
        beehiveRepository.save(beehive);
    }

    public List<Beehive> getBeehivesOfUser(Integer id){
        return this.beehiveRepository.getBeehivesByUserId(id);
    }
}
