package milosz.spring01.service;

import milosz.spring01.model.Beehive;
import milosz.spring01.repository.BeehiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    public Page<Beehive> findPaginate(int pageNumber,int pageSize){
        Pageable pageable= PageRequest.of(pageNumber - 1,pageSize);
        return this.beehiveRepository.findAll(pageable);
    }
}
