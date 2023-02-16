package com.nashss.se.simple_plan.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.simple_plan.activity.requests.CreateExpenseRequest;
import com.nashss.se.simple_plan.activity.results.CreateExpenseResult;

public class CreateExpenseLambda extends LambdaActivityRunner
        <CreateExpenseRequest, CreateExpenseResult>
        implements RequestHandler<LambdaRequest<CreateExpenseRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateExpenseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateExpenseRequest.class),
                (request, serviceComponent) -> serviceComponent.provideCreateExpenseActivity().handleCreateExpenseRequest(request)
        );
    }
}
