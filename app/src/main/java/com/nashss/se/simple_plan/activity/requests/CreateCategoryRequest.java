package com.nashss.se.simple_plan.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateCategoryRequest.Builder.class)
public class CreateCategoryRequest {

    private final String categoryName;

    private final double budgetedAmount;

    private final boolean goalToSave;

    private CreateCategoryRequest(String categoryName, double budgetedAmount, boolean goalToSave) {
        this.categoryName = categoryName;
        this.budgetedAmount = budgetedAmount;
        this.goalToSave = goalToSave;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getBudgetedAmount() {
        return budgetedAmount;
    }

    public boolean getGoalToSave() {
        return goalToSave;
    }

    @Override
    public String toString() {
        return "CreateBudgetRequest{" +
                "categoryName='" + categoryName + '\'' +
                ", budgetedAmount='" + budgetedAmount + '\'' +
                ", goalToSave='" + goalToSave + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private String categoryName;

        private double budgetedAmount;

        private boolean goalToSave;

        public Builder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder withBudgetedAmount(double budgetedAmount) {
            this.budgetedAmount = budgetedAmount;
            return this;
        }

        public Builder withGoalToSave(boolean goalToSave) {
            this.goalToSave = goalToSave;
            return this;
        }

        public CreateCategoryRequest build() {
            return new CreateCategoryRequest(categoryName, budgetedAmount, goalToSave);
        }
    }
}
