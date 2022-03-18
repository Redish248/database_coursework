package itmo.coursework.impl;

import itmo.coursework.entity.statistic.TransactionsBudget;
import itmo.coursework.repository.statistic.TransactionRepository;
import itmo.coursework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionsBudget getTransactionsBudgetByUid(long uid) {
        return transactionRepository.findTransactionsBudgetByUid(uid);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByTransactionOwner(String owner) {
        return transactionRepository.findTransactionsBudgetsByTransactionOwner(owner);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByPurpose(String purpose) {
        return transactionRepository.findTransactionsBudgetsByPurpose(purpose);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByDate(Timestamp timestamp) {
        return transactionRepository.findTransactionsBudgetsByDate(timestamp);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByDateGreaterThan(Timestamp timestamp) {
        return transactionRepository.findTransactionsBudgetsByDateGreaterThan(timestamp);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByDateLessThan(Timestamp timestamp) {
        return transactionRepository.findTransactionsBudgetsByDateLessThan(timestamp);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByAmountGreaterThan(Long amount) {
        return transactionRepository.findTransactionsBudgetsByAmountGreaterThan(amount);
    }

    @Override
    public List<TransactionsBudget> getTransactionsBudgetsByAmountLessThan(Long amount) {
        return transactionRepository.findTransactionsBudgetsByAmountLessThan(amount);
    }
}
