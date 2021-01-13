package unary.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import operation.Operation;
import operation.OperationRequest;
import operation.OperationResponse;
import operation.OperationServiceGrpc;

/**
 * @author : J. Andres Boyaca (janbs)
 * @since : 13/01/21
 **/
public class GRPCClient {

    public static void main(String[] args) {
        System.out.println("Running as gRPC unary.client..");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext() //Just for local development
                .build();

        OperationServiceGrpc.OperationServiceBlockingStub stub =  OperationServiceGrpc.newBlockingStub(channel);

        //Create your "payload"
        Operation operation =  Operation.newBuilder().setDescription("test").build();
        OperationRequest operationRequest =  OperationRequest.newBuilder().setOperation(operation).build();

        //Call operation RPC
        OperationResponse operation1 = stub.operation(operationRequest);
        System.out.println(operation1.toString());

        //Close the chanel
        channel.shutdown();



    }
}
