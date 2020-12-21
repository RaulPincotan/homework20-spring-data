package ro.fasttrackit.homework20.homework20springdata.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework20.homework20springdata.entity.Transaction;
import ro.fasttrackit.homework20.homework20springdata.entity.Type;
import ro.fasttrackit.homework20.homework20springdata.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public List<Transaction> getAllByTypeAndMinAMount(@RequestParam(required = false) Type type,
                                                      @RequestParam(required = false) double minAmount) {
        return transactionService.getAllByTypeAndMinAmount(type, minAmount);
    }

    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return transaction;
    }

    @GetMapping("{id}")
    public Transaction getTransaction(@PathVariable int id) {
        return transactionService.getTransaction(3).orElseThrow();
    }

    @PutMapping("{transactionId}")
    public Transaction replaceTransaction(@PathVariable int transactionId, Transaction transaction) {

        return transactionService.replaceTransaction(transactionId, transaction).orElseThrow();

    }

    @PatchMapping("{transactionId}")
    public Transaction updateTransaction(@PathVariable int transactionId, String product, double amount) {
        return transactionService.updateTransactionDetails(transactionId, product, amount).orElseThrow();
    }

    @DeleteMapping("{transactionId}")
    public Transaction deleteTransaction(@PathVariable int transactionId) {
        return transactionService.deleteTransaction(transactionId).orElseThrow();
    }


}
