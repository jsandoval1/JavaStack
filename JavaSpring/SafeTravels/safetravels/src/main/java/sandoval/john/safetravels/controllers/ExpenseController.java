package sandoval.john.safetravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import jakarta.validation.Valid;
import sandoval.john.safetravels.models.Expense;
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
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        Expense newExpense = new Expense(); // Create a new Expense object and add it to the model
        model.addAttribute("expense", newExpense);
        return "ViewAllExpenses";
    }

    // Handle GET request to retrieve one expense from the database using the
    // PathVariable
    @GetMapping("/expenses/{id}")
    public String getExpenseById(Model model, @PathVariable long id) {
        model.addAttribute("expense", expenseService.findExpense(id));
        return "ViewExpense";
    }

    // Handle POST request to save an expense to the database, checking for
    // validations
    @PostMapping("/expenses")
    public String saveExpense(@Valid @ModelAttribute Expense expense, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenses", expenseService.findAll()); // Add the list of expenses for when we render the ViewAllExpenses page, since it failed.
            return "ViewAllExpenses";
        } else {
            expenseService.save(expense);
            return "redirect:/expenses";
        }
    }

    // Handle Get request to update an expense in the database
    @GetMapping("/expenses/{id}/edit")
    public String editExpense(Model model, @PathVariable long id) {
        model.addAttribute("expense", expenseService.findExpense(id));
        return "EditExpense";
    }

    // Handle PUT request to update an expense in the database, checking for
    // validations
    @PutMapping("/expenses/{id}")
    public String updateExpense(@PathVariable long id, @Valid @ModelAttribute Expense expense,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenses", expenseService.findAll()); // Add the list of expenses for when we render the ViewAllExpenses page, since it failed.
            return "EditExpense"; // ! Since it failed, return/keep the user on the page
        } else {
            expenseService.updateExpense(expense); // * Update the expense since
            return "redirect:/expenses";
        }
    }

    // Handle DELETE request to delete an expense from the database
    @DeleteMapping("/expenses/{id}/delete")
    public String deleteExpense(@PathVariable("id") long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

}
