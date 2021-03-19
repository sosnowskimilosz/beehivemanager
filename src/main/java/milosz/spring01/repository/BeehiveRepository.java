package milosz.spring01.repository;

import milosz.spring01.model.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeehiveRepository extends JpaRepository<Beehive,Integer> {

}
