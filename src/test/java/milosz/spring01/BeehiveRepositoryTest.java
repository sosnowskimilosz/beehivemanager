package milosz.spring01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import milosz.spring01.model.Beehive;
import milosz.spring01.repository.BeehiveRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = UserApplication.class)
public class BeehiveRepositoryTest {


    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    BeehiveRepository beehiveRepository;

    @Test
    public void repositoryShouldHaveTwoElements(){
        List<Beehive> beehives=beehiveRepository.findAll();
        assertEquals(2,beehives.size());
    }

}