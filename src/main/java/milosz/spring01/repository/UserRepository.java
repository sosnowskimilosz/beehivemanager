package milosz.spring01.repository;

import milosz.spring01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.username =?1")
    User findByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.username =?1")
    Integer findIdOfUsername(String username);

}
