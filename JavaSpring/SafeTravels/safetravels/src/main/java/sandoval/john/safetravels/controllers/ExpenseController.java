package sandoval.john.safetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sandoval.john.safetravels.service.ExpenseService;

@Controller
public class ExpenseController {

    // * Inject expense service into the controller using the @Autowired
    @Autowired
    ExpenseService expenseService;

    // Handle GET request to retrieve all expenses from the database, add them to
    // the model to pass to the JSP page
    @GetMapping("/expenses")
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return "ViewAllExpenses";
    }

    // Handle GET request to retrieve an expense from the database using the PathVariable
    @GetMapping("/expenses/{id}")
    public String getExpenseById(Model model, @PathVariable long id) {
        model.addAttribute("expense", expenseService.findById(id));
        return "ViewExpense";
    }

    // !Create post method to save an expense to the database
    // Handle POST request to save an expense to the database

}
