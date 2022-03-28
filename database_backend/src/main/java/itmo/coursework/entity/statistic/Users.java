package itmo.coursework.entity.statistic;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
@Table(name = "users", schema = "public", catalog = "database_coursework")
public class Users {
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

    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Basic
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "nick")
    private String nick;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_type", referencedColumnName = "uid")
    private UserType userType;

    public Users() {

    }

    public Users(String name, String surname, Date dateOfBirth, String gender, String nick, String email, String password, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}
