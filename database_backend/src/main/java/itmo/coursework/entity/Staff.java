package itmo.coursework.entity;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

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
}
