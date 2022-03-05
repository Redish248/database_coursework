package itmo.coursework.controller;

import itmo.coursework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
}
