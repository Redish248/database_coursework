package itmo.coursework.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "objects", schema = "public", catalog = "database_coursework")
public class Objects {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private long uid;

    @NotNull
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Min(0)
    @Column(name = "price")
    private Integer price;

    @Min(0)
    @Column(name = "amount")
    private Integer amount;
}
