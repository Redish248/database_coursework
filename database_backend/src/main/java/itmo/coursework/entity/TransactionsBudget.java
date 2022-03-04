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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "transactions_budget", schema = "public", catalog = "database_coursework")
public class TransactionsBudget {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private long uid;

    @Min(0)
    @Column(name = "amount")
    private Long amount;

    @Basic
    @Column(name = "transaction_owner")
    private String transactionOwner;

    @Basic
    @Column(name = "purpose")
    private String purpose;

    @Basic
    @Column(name = "date")
    private Timestamp date;
}
