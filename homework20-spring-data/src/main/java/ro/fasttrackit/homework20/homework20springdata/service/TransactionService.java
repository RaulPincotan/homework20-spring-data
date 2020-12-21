package ro.fasttrackit.homework20.homework20springdata.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.homework20.homework20springdata.entity.Transaction;
import ro.fasttrackit.homework20.homework20springdata.entity.Type;
import ro.fasttrackit.homework20.homework20springdata.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;


    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);

    }


    public List<Transaction> findByType(Type type) {
        return transactionRepository.findByType(type);

    }

    public List<Transaction> getAllByTypeAndMinAmount(Type type, double minAmount) {
        return transactionRepository.findAllByTypeAndAmountGreaterThan(type, minAmount);
    }

    public Optional<Transaction> replaceTransaction(int id, Transaction transaction) {
        transaction.setId(id);
        return Optional.of(transaction);
    }

    public Optional<Transaction> getTransaction(int id) {
        return transactionRepository.findById(id);
    }

    public Optional<Transaction> deleteTransaction(int id) {
        Optional<Transaction> transaciton = transactionRepository.findById(id);
        transactionRepository.delete(transaciton.get());
        return transaciton;
    }

    public Optional<Transaction> updateTransactionDetails(int id, String product, double amount) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        transaction.orElseThrow().setProduct(product);
        transaction.orElseThrow().setAmount(amount);

        return transaction;
    }
}
