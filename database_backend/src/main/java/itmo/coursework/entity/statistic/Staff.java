package itmo.coursework.entity.statistic;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
@Table(name = "staff", schema = "public", catalog = "database_coursework")
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private long uid;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    //отчество
    @Basic
    @Column(name = "patronymic")
    private String patronymic;

    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Basic
    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "position", referencedColumnName = "uid")
    private Position positionType;

    @Min(0)
    @Column(name = "salary")
    private Integer salary;

    @Column
    private Integer experience;

    @Basic
    @Column(name = "first_work_date")
    private Date firstWorkDate;

    @OneToOne
    @JoinColumn(name = "users", referencedColumnName = "uid")
    private Users user;

    public long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public Position getPositionType() {
        return positionType;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public Date getFirstWorkDate() {
        return firstWorkDate;
    }

    public Staff() {
    }

    public Staff(String name, String surname, String patronymic, Date dateOfBirth, String gender, Position positionType, Integer salary, Integer experience, Date firstWorkDate, Users user) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.positionType = positionType;
        this.salary = salary;
        this.experience = experience;
        this.firstWorkDate = firstWorkDate;
        this.user = user;
    }

    public Staff(long uid, String name, String surname, String patronymic, Date dateOfBirth, String gender, Position positionType, Integer salary, Integer experience, Date firstWorkDate) {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.positionType = positionType;
        this.salary = salary;
        this.experience = experience;
        this.firstWorkDate = firstWorkDate;
    }
}
