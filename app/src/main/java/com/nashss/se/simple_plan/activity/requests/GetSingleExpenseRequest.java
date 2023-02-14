package com.nashss.se.simple_plan.activity.requests;

public class GetSingleExpenseRequest {

    private final String expenseId;

    private GetSingleExpenseRequest(String expenseId) {
        this.expenseId = expenseId;
    }
    public String getExpenseId() {
        return expenseId;
    }

    @Override
    public String toString() {
        return "GetSingleExpenseRequest{" +
                "expenseId='" + expenseId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String expenseId;

        public Builder withExpenseId(String expenseId) {
            this.expenseId = expenseId;
            return this;
        }

        public GetSingleExpenseRequest build() {
            return new GetSingleExpenseRequest(expenseId);
        }
    }
}
