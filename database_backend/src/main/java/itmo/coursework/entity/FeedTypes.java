package itmo.coursework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data
@Table(name = "feed_types", schema = "public", catalog = "database_coursework")
public class FeedTypes {
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

    @JsonIgnore
    @OneToMany(mappedBy = "feedType", fetch = FetchType.LAZY)
    private Collection<FeedAvailability> feeds;
}
