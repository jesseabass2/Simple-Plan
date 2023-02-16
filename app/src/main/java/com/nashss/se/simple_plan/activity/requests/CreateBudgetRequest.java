package com.nashss.se.simple_plan.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateBudgetRequest.Builder.class)
public class CreateBudgetRequest {

    private final String budgetName;

    private final Double totalIncome;

    private final Double totalExpenses;

    private final Double totalBudgeted;

    private final Double fundsAvailable;


    private CreateBudgetRequest(String budgetName,
                               Double totalIncome,
                               Double totalExpenses,
                               Double totalBudgeted,
                               Double fundsAvailable) {
        this.budgetName = budgetName;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.totalBudgeted = totalBudgeted;
        this.fundsAvailable = fundsAvailable;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public Double getTotalBudgeted() {
        return totalBudgeted;
    }

    public Double getFundsAvailable() {
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
        private Double totalIncome;
        private Double totalExpenses;
        private Double totalBudgeted;
        private Double fundsAvailable;

        public Builder withBudgetName(String budgetName) {
            this.budgetName = budgetName;
            return this;
        }
        public Builder withTotalIncome(Double totalIncome) {
            this.totalIncome = totalIncome;
            return this;
        }
        public Builder withTotalExpenses(Double totalExpenses) {
            this.totalExpenses = totalExpenses;
            return this;
        }
        public Builder withTotalBudgeted(Double totalBudgeted) {
            this.totalBudgeted = totalBudgeted;
            return this;
        }
        public Builder withFundsAvailable(Double fundsAvailable) {
            this.fundsAvailable = fundsAvailable;
            return this;
        }

        public CreateBudgetRequest build() {
            return new CreateBudgetRequest(budgetName, totalIncome, totalExpenses, totalBudgeted, fundsAvailable);
        }
    }
}
