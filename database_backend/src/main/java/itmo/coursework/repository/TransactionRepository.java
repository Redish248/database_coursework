package itmo.coursework.repository;

import itmo.coursework.entity.TransactionsBudget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionsBudget, Integer> {
}
