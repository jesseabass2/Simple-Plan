package com.nashss.se.simple_plan.activity;

import com.nashss.se.simple_plan.dynamodb.BudgetDao;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class CreateBudgetActivity {
    private final Logger log;

    private final BudgetDao budgetDao;

    /**
     * Instantiates a new CreateBudgetActivity object.
     *
     */
    @Inject
    public CreateBudgetActivity(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
        log = LogManager.getLogger();
    }

    public CreateDepartmentResult handleBudgetRequest(CreateDepartmentRequest request) {

        log.info("Received Create Budget Request {}", request);

    }
}
