package com.nashss.se.simple_plan.activity;

import com.nashss.se.simple_plan.dynamodb.BudgetDao;
import com.nashss.se.simple_plan.activity.requests.CreateBudgetRequest;
import com.nashss.se.simple_plan.activity.results.CreateBudgetResult;
import com.nashss.se.simple_plan.dynamodb.models.Budget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class CreateBudgetActivity {
    private final Logger log = LogManager.getLogger();

    private final BudgetDao budgetDao;

    /**
     * Instantiates a new CreateBudgetActivity object.
     *
     */
    @Inject
    public CreateBudgetActivity(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    public CreateBudgetResult handleBudgetRequest(CreateBudgetRequest createBudgetRequest) {
        log.info("Received Create Budget Request {}", createBudgetRequest);

        Budget newBudget = new Budget();
        newBudget.setBudgetName(createBudgetRequest.getName());
        return null;
    }
}
