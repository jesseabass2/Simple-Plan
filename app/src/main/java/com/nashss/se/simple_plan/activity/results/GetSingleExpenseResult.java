package com.nashss.se.simple_plan.activity.results;

import com.nashss.se.simple_plan.dynamodb.models.Expense;
import com.nashss.se.simple_plan.models.ExpenseModel;

public class GetSingleExpenseResult {

    private final ExpenseModel singleExpense;

    public GetSingleExpenseResult(Expense singleExpense) {
        this.singleExpense = new ExpenseModel(singleExpense);
    }

    public ExpenseModel getSingleExpense() {
        return singleExpense;
    }

    @Override
    public String toString() {
        return "GetSingleExpenseResult{" +
                "expense='" + singleExpense + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Expense singleExpense;

        public Builder withSingleExpense(Expense singleExpense) {
            this.singleExpense = singleExpense;
            return this;
        }

        public GetSingleExpenseResult build() {
            return new GetSingleExpenseResult(singleExpense);
        }
    }
}
