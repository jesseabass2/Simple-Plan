package com.nashss.se.simple_plan.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.simple_plan.activity.requests.CreateBudgetRequest;
import com.nashss.se.simple_plan.activity.results.CreateBudgetResult;

public class CreateBudgetLambda extends LambdaActivityRunner<CreateBudgetRequest,
        CreateBudgetResult> implements RequestHandler
        <LambdaRequest<CreateBudgetRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateBudgetRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateBudgetRequest.class),
                ((request, serviceComponent) ->
                        serviceComponent.provideCreateBudgetActivity().handleBudgetRequest(request))
        );
    }
}
