import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;
import server.ClientServer;

public class ServerTest {

    private Server clientServer;
    private ManagedChannel clientChannel;
    private int clientPort;

    @BeforeEach
    void setup() throws Exception {
        // Start ClientServer on a random free port
        clientServer = ServerBuilder.forPort(0)
            .addService(new ClientServer())
            .build()
            .start();
        
        clientPort = clientServer.getPort();

        // Create a channel to the ClientServer
        clientChannel = ManagedChannelBuilder.forAddress("localhost", clientPort)
            .usePlaintext()
            .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        if (clientChannel != null) {
            clientChannel.shutdownNow();
            clientChannel.awaitTermination(5, TimeUnit.SECONDS);
        }

        if (clientServer != null) {
            clientServer.shutdownNow();
            clientServer.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    @Test
    void testClientServerCommunication() {
        // Use the clientChannel for ClientServer calls
        SenddataGrpc.SenddataBlockingStub stub = SenddataGrpc.newBlockingStub(clientChannel);

        sendclientserver request = sendclientserver.newBuilder()
                .setFileLocation("test/testInputFile.test")
                .setOutputLocation(sendclientserver.outLocation.print)
                .build();

        sendresponse response = stub.senddatatoclient(request);

        assertEquals("File accepted. Output Type: print.", response.getMessage());
        System.out.println("Test passed: Received response - " + response.getMessage());
    }
}
