package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DataStoreServer {
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(50052)
                    .addService(new ParseFileServiceImpl())
                    .addService(new WriteIntegerServiceImpl())
                    .build()
                    .start();

            System.out.println("DataStore Server started on port 50052");

            server.awaitTermination();
        } catch (InterruptedException | IOException e) {
            System.out.println("Unexpected interruption on DataStore Server on port 50052");
            throw new RuntimeException(e);
        }

    }
}
