package com.nashss.se.simple_plan.activity;

import com.nashss.se.simple_plan.activity.requests.GetSingleExpenseRequest;
import com.nashss.se.simple_plan.activity.results.GetSingleExpenseResult;
import com.nashss.se.simple_plan.dynamodb.ExpenseDao;
import com.nashss.se.simple_plan.dynamodb.models.Expense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetSingleExpenseActivity {
    private final Logger log = LogManager.getLogger();

    private final ExpenseDao expenseDao;


    @Inject
    public GetSingleExpenseActivity(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public GetSingleExpenseResult handleSingleExpenseRequest(final GetSingleExpenseRequest
                                                                     getSingleExpenseRequest) {

        log.info("Received GetSingleExpenseRequest {}", getSingleExpenseRequest);

        String requestedExpense = getSingleExpenseRequest.getExpenseId();
        Expense singleExpense = expenseDao.getExpense(requestedExpense);

        return GetSingleExpenseResult.builder()
                .withSingleExpense(singleExpense)
                .build();
    }

}
