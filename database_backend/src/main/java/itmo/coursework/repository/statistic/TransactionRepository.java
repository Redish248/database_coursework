package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.TransactionsBudget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionsBudget, Long> {
    TransactionsBudget findTransactionsBudgetByUid(long uid);

    List<TransactionsBudget> findTransactionsBudgetsByTransactionOwner(String owner);

    //TODO: change to regex
    List<TransactionsBudget> findTransactionsBudgetsByPurpose(String purpose);

    List<TransactionsBudget> findTransactionsBudgetsByDate(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByDateGreaterThan(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByDateLessThan(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByAmountGreaterThan(Long amount);

    List<TransactionsBudget> findTransactionsBudgetsByAmountLessThan(Long amount);
}
