package sandoval.john.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.safetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {

    //Method to retrieve all expenses from the database'
    //! Needed to to retrieve all expenses as alist from the database in the service
    List<Expense> findAll();
}
