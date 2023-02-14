package com.nashss.se.simple_plan.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateBudgetRequest.Builder.class)
public class CreateBudgetRequest {

    private final String budgetName;

    private final double totalIncome;

    private final double totalExpenses;

    private final double totalBudgeted;

    private final double fundsAvailable;


    private CreateBudgetRequest(String budgetName,
                               double totalIncome,
                               double totalExpenses,
                               double totalBudgeted,
                               double fundsAvailable) {
        this.budgetName = budgetName;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.totalBudgeted = totalBudgeted;
        this.fundsAvailable = fundsAvailable;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getTotalBudgeted() {
        return totalBudgeted;
    }

    public double getFundsAvailable() {
        return fundsAvailable;
    }

    @Override
    public String toString() {
        return "CreateBudgetRequest{" +
                "budgetName='" + budgetName + '\'' +
                ", totalIncome='" + totalIncome + '\'' +
                ", totalExpenses='" + totalExpenses + '\'' +
                ", totalBudgeted='" + totalBudgeted + '\'' +
                ", fundsAvailable='" + fundsAvailable + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String budgetName;
        private double totalIncome;
        private double totalExpenses;
        private double totalBudgeted;
        private double fundsAvailable;

        public Builder withBudgetName(String budgetName) {
            this.budgetName = budgetName;
            return this;
        }
        public Builder withTotalIncome(double totalIncome) {
            this.totalIncome = totalIncome;
            return this;
        }
        public Builder withTotalExpenses(double totalExpenses) {
            this.totalExpenses = totalExpenses;
            return this;
        }
        public Builder withTotalBudgeted(double totalBudgeted) {
            this.totalBudgeted = totalBudgeted;
            return this;
        }
        public Builder withFundsAvailable(double fundsAvailable) {
            this.fundsAvailable = fundsAvailable;
            return this;
        }

        public CreateBudgetRequest build() {
            return new CreateBudgetRequest(budgetName, totalIncome, totalExpenses, totalBudgeted, fundsAvailable);
        }
    }
}
