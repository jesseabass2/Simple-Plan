package com.nashss.se.simple_plan.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.simple_plan.activity.requests.CreateCategoryRequest;
import com.nashss.se.simple_plan.activity.results.CreateCategoryResult;

public class CreateCategoryLambda extends LambdaActivityRunner<
        CreateCategoryRequest, CreateCategoryResult>
        implements RequestHandler<LambdaRequest<CreateCategoryRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateCategoryRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateCategoryRequest.class),
                (request, serviceComponent) -> serviceComponent.provideCreateCategoryActivity().handleCategoryRequest(request)
        );
    }
}
