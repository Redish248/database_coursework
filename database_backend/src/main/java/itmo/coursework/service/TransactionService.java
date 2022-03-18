package itmo.coursework.service;

import itmo.coursework.entity.statistic.TransactionsBudget;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionService {
    TransactionsBudget getTransactionsBudgetByUid(long uid);

    List<TransactionsBudget> getTransactionsBudgetsByTransactionOwner(String owner);

    //TODO: change to regex
    List<TransactionsBudget> getTransactionsBudgetsByPurpose(String purpose);

    List<TransactionsBudget> getTransactionsBudgetsByDate(Timestamp timestamp);

    List<TransactionsBudget> getTransactionsBudgetsByDateGreaterThan(Timestamp timestamp);

    List<TransactionsBudget> getTransactionsBudgetsByDateLessThan(Timestamp timestamp);

    List<TransactionsBudget> getTransactionsBudgetsByAmountGreaterThan(Long amount);

    List<TransactionsBudget> getTransactionsBudgetsByAmountLessThan(Long amount);
}
