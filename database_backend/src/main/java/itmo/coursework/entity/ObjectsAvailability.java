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

@Entity
@Data
@Table(name = "objects_availability", schema = "public", catalog = "database_coursework")
public class ObjectsAvailability {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private long uid;

    @ManyToOne
    @JoinColumn(name = "object_type", referencedColumnName = "uid")
    private Objects objectType;

    @Min(0)
    @Column(name = "amount")
    private Integer amount;
}
