package milosz.spring01.repository;

import milosz.spring01.model.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeehiveRepository extends JpaRepository<Beehive,Integer> {

    @Query("SELECT b FROM Beehive b WHERE b.user.id=?1")
    List<Beehive> getBeehivesByUserId(Integer id);

}
