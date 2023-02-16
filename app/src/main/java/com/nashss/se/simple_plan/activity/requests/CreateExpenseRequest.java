package com.nashss.se.simple_plan.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;

@JsonDeserialize(builder = CreateExpenseRequest.Builder.class)
public class CreateExpenseRequest {

    private final String expenseId;

    private final String category;

    private final Double amount;

    private final LocalDate date;

    private final String note;


    public CreateExpenseRequest(String expenseId, String category, Double amount, LocalDate date, String note) {
        this.expenseId = expenseId;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public String getExpenseId() {
        return expenseId;
    }
    public String getCategory() {
        return category;
    }
    public Double getAmount() {
        return amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "CreateExpenseRequest{" +
                "expenseId='" + expenseId + '\'' +
                ", category='" + category + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", not='" + note + '}';
    }
    public static Builder builder() {
        return new Builder();
    }
    @JsonPOJOBuilder
    public static class Builder {
        private String expenseId;

        private String category;

        private Double amount;

        private LocalDate date;

        private String note;

        public Builder withExpenseId(String expenseId) {
            this.expenseId = expenseId;
            return this;
        }
        public Builder withCategory(String category) {
            this.category = category;
            return this;
        }
        public Builder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }
        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder withNote(String note) {
            this.note = note;
            return this;
        }
        public CreateExpenseRequest build() {
            return new CreateExpenseRequest(expenseId, category, amount, date, note);
        }
    }
}
