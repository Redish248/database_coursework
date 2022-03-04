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

@Entity
@Data
@Table(name = "feed_availability", schema = "public", catalog = "database_coursework")
public class FeedAvailability {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private long uid;

    @ManyToOne
    @JoinColumn(name = "feed", referencedColumnName = "uid")
    private FeedTypes feedType;

    @Basic
    @Column(name = "amount")
    private Integer amount;
}
