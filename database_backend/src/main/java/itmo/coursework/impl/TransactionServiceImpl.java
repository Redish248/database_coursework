package itmo.coursework.impl;

import itmo.coursework.repository.TransactionRepository;
import itmo.coursework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
}
