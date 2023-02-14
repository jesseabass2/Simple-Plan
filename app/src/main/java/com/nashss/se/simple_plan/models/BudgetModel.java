package com.nashss.se.simple_plan.models;

import com.nashss.se.simple_plan.dynamodb.models.Budget;

import java.util.Objects;

public class BudgetModel {

    private String budgetName;

    private double totalIncome;

    private double totalExpenses;

    private double totalBudgeted;

    private double fundsAvailable;


    public BudgetModel(Budget budget) {
        this.budgetName = budget.getBudgetName();
        this.totalIncome = budget.getTotalIncome();
        this.totalExpenses = budget.getTotalExpenses();
        this.totalBudgeted = budget.getTotalBudgeted();
        this.fundsAvailable = budget.getFundsAvailable();
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BudgetModel that = (BudgetModel) o;
        return Objects.equals(budgetName, that.budgetName) &&
                Objects.equals(totalIncome, that.totalIncome) &&
                Objects.equals(totalExpenses, that.totalExpenses) &&
                Objects.equals(totalBudgeted, that.totalBudgeted) &&
                Objects.equals(fundsAvailable, that.fundsAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                budgetName,
                totalIncome,
                totalExpenses,
                totalBudgeted,
                fundsAvailable
        );
    }

    @Override
    public String toString() {
        return "BudgetModel{" +
                "budgetName='" + budgetName + '\'' +
                ", totalIncome='" + totalIncome + '\'' +
                ", totalExpenses='" + totalExpenses + '\'' +
                ", totalBudgeted='" + totalBudgeted + '\'' +
                ", fundsAvailable='" + fundsAvailable + '\'' +
                '}';
    }
}
