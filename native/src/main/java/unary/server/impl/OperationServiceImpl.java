package unary.server.impl;

import io.grpc.stub.StreamObserver;
import operation.Operation;
import operation.OperationRequest;
import operation.OperationResponse;
import operation.OperationServiceGrpc;

/**
 * @author : J. Andres Boyaca (janbs)
 * @since : 13/01/21
 **/
public class OperationServiceImpl extends OperationServiceGrpc.OperationServiceImplBase {

    @Override
    public void operation(OperationRequest request, StreamObserver<OperationResponse> responseObserver) {
        //Get the date sent it
        Operation operation =  request.getOperation();
        //Create a response
        OperationResponse operationResponse =  OperationResponse.newBuilder()
                .setResult(operation.getDescription() + " with unary.server").build();

        responseObserver.onNext(operationResponse);
        responseObserver.onCompleted();
    }
}