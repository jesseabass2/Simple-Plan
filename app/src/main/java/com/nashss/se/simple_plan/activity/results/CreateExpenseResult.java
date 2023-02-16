package com.nashss.se.simple_plan.activity.results;

import com.nashss.se.simple_plan.dynamodb.models.Expense;
import com.nashss.se.simple_plan.models.ExpenseModel;

public class CreateExpenseResult {

    private final ExpenseModel expenseModel;

    private CreateExpenseResult(Expense expense) {
        this.expenseModel = new ExpenseModel(expense);
    }

    public ExpenseModel getExpense() {
        return expenseModel;
    }

    @Override
    public String toString() {
        return "CreateExpenseResult{" +
                "expense=" + expenseModel + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Expense expense;

        public Builder withExpense(Expense expense) {
            this.expense = expense;
            return this;
        }

        public CreateExpenseResult build() {
            return new CreateExpenseResult(expense);
        }

    }
}
