package milosz.spring01.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Entity
@Table(name = "beehives")
public class Beehive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Number is mandatory")
    private String number;

    private BeehiveType type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastCheckUpDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishDate;

    private BeehiveMark mark;

    private Boolean queen = null;

    @ManyToOne
    private User user;

    public Beehive() {
    }

    public Beehive(String number, BeehiveType type, LocalDate lastCheckUpDate, LocalDate establishDate, BeehiveMark mark, Boolean queen) {
        this.number = number;
        this.type = type;
        this.lastCheckUpDate = lastCheckUpDate;
        this.establishDate = establishDate;
        this.mark = mark;
        this.queen = queen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BeehiveType getType() {
        return type;
    }

    public void setType(BeehiveType type) {
        this.type = type;
    }

    public LocalDate getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(LocalDate establishDate) {
        this.establishDate = establishDate;
    }

    public LocalDate getLastCheckUpDate() {
        return lastCheckUpDate;
    }

    public void setLastCheckUpDate(LocalDate lastCheckUpDate) {
        this.lastCheckUpDate = lastCheckUpDate;
    }

    public Boolean getQueen() {
        return queen;
    }

    public void setQueen(Boolean queen) {
        this.queen = queen;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BeehiveMark getMark() {
        return mark;
    }

    public void setMark(BeehiveMark mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Beehive{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", lastCheckUpDate=" + lastCheckUpDate +
                ", establishDate=" + establishDate +
                ", mark=" + mark +
                ", queen=" + queen +
                '}';
    }
}
