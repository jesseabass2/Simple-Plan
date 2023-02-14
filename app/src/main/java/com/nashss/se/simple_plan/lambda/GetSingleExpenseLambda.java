package com.nashss.se.simple_plan.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.simple_plan.activity.requests.GetSingleExpenseRequest;
import com.nashss.se.simple_plan.activity.results.GetSingleExpenseResult;


public class GetSingleExpenseLambda extends
        LambdaActivityRunner<GetSingleExpenseRequest,
                GetSingleExpenseResult> implements
        RequestHandler<LambdaRequest<GetSingleExpenseRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetSingleExpenseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetSingleExpenseRequest.builder()
                                .withExpenseId(path.get("expenseId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetSingleExpenseActivity().handleSingleExpenseRequest(request)
        );
    }
}
