package sandoval.john.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.safetravels.models.Expense;
import sandoval.john.safetravels.service.ExpenseService;

@RestController
public class ExpenseApiController {

    //* Inject expense service into the API controller
    private ExpenseService expenseService;

    //* Constructor for the API controller with the expense service
    public ExpenseApiController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // ? Part 1
    // Handle GET request to retrieve all expenses from the database
    @GetMapping("/api/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

    // Handle GET request to retrieve an expense from the database using the PathVariable
    @GetMapping("/api/expenses/{id}")
    public Expense getExpenseById(@PathVariable long id) {
        return expenseService.findById(id);
    }

    // Handle POST request to save an expense to the database
    @PostMapping("/api/expenses")
    public Expense saveExpense(Expense expense) {
        return expenseService.save(expense);
    }

}
