package server.unary;

import io.grpc.ServerBuilder;
import io.grpc.Server;
import server.unary.service.impl.OperationServiceImpl;

import java.io.IOException;

/**
 * @author : J. Andres Boyaca (janbs)
 * @since : 13/01/21
 **/
public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Running as gRPC server..");

        Server server = ServerBuilder
                .forPort(8080)
                .addService(new OperationServiceImpl()) // Add the service to use their methods
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        server.awaitTermination();
    }

}
