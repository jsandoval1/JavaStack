package sandoval.john.safetravels.service;

import java.util.List;

import org.springframework.stereotype.Service;

// import jakarta.validation.Valid;
import sandoval.john.safetravels.models.Expense;
import sandoval.john.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    // * Inject expense repository into the service
    private ExpenseRepository expenseRepository;

    // Constructor for the service with the expense repository
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // ? Part 1
    // Method to create an expense to the database
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Method to retrieve all expenses from the database
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // Method to retrieve an expense from the database or return null if not found
    public Expense findExpense(long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // ? Part 2
    // Method to update an expense
    public void updateExpense(Expense updateExpense) {
        expenseRepository.save(updateExpense);
    }

    //? Part 3
    // Method to delete an expense
    public void deleteExpense(long id) {
        expenseRepository.deleteById(id);
    }

}
