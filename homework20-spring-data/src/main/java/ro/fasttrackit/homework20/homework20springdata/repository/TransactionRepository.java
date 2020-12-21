package ro.fasttrackit.homework20.homework20springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homework20.homework20springdata.entity.Transaction;
import ro.fasttrackit.homework20.homework20springdata.entity.Type;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


  List<Transaction> findByType(Type type);


  List<Transaction> findAllByTypeAndAmountGreaterThan(Type type, double minAMount);

}
