package com.example.springboot.service.impl;

import com.example.springboot.grpc.OperationServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author : J. Andres Boyaca (janbs)
 * @since : 13/01/21
 **/
@Service
public class GRPCClient {

    @GrpcClient("serviceGRPC")
    private OperationServiceGrpc.OperationServiceBlockingStub operationServiceBlockingStub;


    public void useService(){
        //Create your "payload"
        com.example.springboot.grpc.Operation operation = com.example.springboot.grpc.Operation.newBuilder().setDescription("test").build();
        com.example.springboot.grpc.OperationRequest operationRequest = com.example.springboot.grpc.OperationRequest.newBuilder().setOperation(operation).build();
        com.example.springboot.grpc.OperationResponse operation1 = operationServiceBlockingStub.operation(operationRequest);
        System.out.println(operation1.toString());

    }
}
