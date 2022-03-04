package itmo.coursework.repository;

import itmo.coursework.entity.TransactionsBudget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionsBudget, Long> {
    TransactionsBudget findTransactionsBudgetByUid(long uid);

    List<TransactionsBudget> findTransactionsBudgetsByTransactionOwner(String owner);

    List<TransactionsBudget> findTransactionsBudgetsByPurposeRegex(String purpose);

    List<TransactionsBudget> findTransactionsBudgetsByDate(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByDateGreaterThan(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByDateLessThan(Timestamp timestamp);

    List<TransactionsBudget> findTransactionsBudgetsByAmountGreaterThan(Long amount);

    List<TransactionsBudget> findTransactionsBudgetsByAmountLessThan(Long amount);
}
