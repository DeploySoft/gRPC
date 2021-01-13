package unary.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import unary.server.impl.OperationServiceImpl;

import java.io.IOException;

/**
 * @author : J. Andres Boyaca (janbs)
 * @since : 13/01/21
 **/
public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Running as gRPC unary.server..");

        Server server = ServerBuilder
                .forPort(8080)
                .addService(new OperationServiceImpl()) // Add the service to use their methods
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        server.awaitTermination();
    }

}
