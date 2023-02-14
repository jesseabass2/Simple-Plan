package com.nashss.se.simple_plan.activity.results;


import com.nashss.se.simple_plan.dynamodb.models.Budget;
import com.nashss.se.simple_plan.models.BudgetModel;

public class CreateBudgetResult {

    private final BudgetModel budgetModel;

    private CreateBudgetResult(Budget budget) {
        this.budgetModel = new BudgetModel(budget);
    }

    public BudgetModel getBudget() {
        return budgetModel;
    }

    @Override
    public String toString() {
        return "CreateBudgetResult{" +
                "budget=" + budgetModel +
                "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Budget budget;

        public Builder withBudget(Budget budget) {
            this.budget = budget;
            return this;
        }

        public CreateBudgetResult build() {
            return new CreateBudgetResult(budget);
        }
    }
}
