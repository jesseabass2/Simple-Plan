package com.nashss.se.simple_plan.activity;

import com.nashss.se.simple_plan.activity.requests.CreateExpenseRequest;
import com.nashss.se.simple_plan.activity.results.CreateExpenseResult;
import com.nashss.se.simple_plan.dynamodb.ExpenseDao;
import com.nashss.se.simple_plan.dynamodb.models.Expense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class CreateExpenseActivity {
    private final Logger log = LogManager.getLogger();
    private final ExpenseDao expenseDao;

    @Inject
    public CreateExpenseActivity(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public CreateExpenseResult handleCreateExpenseRequest(CreateExpenseRequest createExpenseRequest) {
        log.info("Received Create Expense Request{}", createExpenseRequest);

        Expense newExpense = new Expense();
        newExpense.setExpenseID(createExpenseRequest.getExpenseId());
        newExpense.setCategory(createExpenseRequest.getCategory());
        newExpense.setAmount(createExpenseRequest.getAmount());
        newExpense.setDate(createExpenseRequest.getDate());
        newExpense.setNote(createExpenseRequest.getNote());

        expenseDao.saveExpense(newExpense);

        return CreateExpenseResult.builder()
                .withExpense(newExpense)
                .build();
    }
}