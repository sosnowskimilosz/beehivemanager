package milosz.spring01.repository;

import milosz.spring01.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;


    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("user@wp.pl");
        user.setPassword("pass123");
        user.setFirstName("Milosz");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
    }

    @Test
    public void testFindUserByEmail(){
        String userName="user@wp.pl";
        User user= repo.findByUsername(userName);
        assertThat(user).isNotNull();
    }

}
