package com.nashss.se.simple_plan.models;

import com.nashss.se.simple_plan.dynamodb.models.Expense;

import java.time.LocalDate;
import java.util.Objects;

public class ExpenseModel {

    private String expenseId;

    private String category;

    private double amount;

    private LocalDate date;

    private String note;


    public ExpenseModel(Expense expense) {
        this.expenseId = expense.getExpenseId();
        this.category = expense.getCategory();
        this.amount = expense.getAmount();
        this.date = expense.getDate();
        this.note = expense.getNote();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExpenseModel that = (ExpenseModel) o;
        return Objects.equals(expenseId, that.expenseId) &&
                Objects.equals(category, that.category) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                expenseId,
                category,
                amount,
                date,
                note);
    }

    @Override
    public String toString() {
        return "ExpenseModel{" +
                "expenseId='" + expenseId + '\'' +
                "category='" + category + '\'' +
                "amount='" + amount + '\'' +
                "date='" + date + '\'' +
                "note='" + note + '\'' +
                '}';
    }
}
