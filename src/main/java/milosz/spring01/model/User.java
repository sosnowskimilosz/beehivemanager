package milosz.spring01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "Username is mandatory")
    @Size(min = 4, max=20)
    String username;

    @NotNull(message = "Password is mandatory")
    @Size(min = 5, max=64)
    String password;

    @NotNull(message = "Name is mandatory")
    @Size(min = 4, max=20)
    String firstName;

    @OneToMany(mappedBy = "user")
    List<Beehive> beehiveList = new ArrayList<>();

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Beehive> getBeehiveList() {
        return beehiveList;
    }

    public void addBeehive(Beehive beehive) {
        this.beehiveList.add(beehive);
    }

    public void removeBeehive(Beehive beehive){
        beehiveList.remove(beehive);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
