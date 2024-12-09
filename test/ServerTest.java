
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;
import server.ClientServer;
class ServerTest {

    private ManagedChannel channel;
    private io.grpc.Server server;
    
    @BeforeEach
    void setup() throws Exception {
        // Create a unique in-process server name to avoid conflicts
        String serverName = InProcessServerBuilder.generateName();

        // Start the in-process gRPC server with ClientServer as the service
        server = InProcessServerBuilder.forName(serverName)
                .directExecutor()  // Synchronous execution
                .addService(new ClientServer())
                .build()
                .start();

        // Create the channel to connect to the in-process server
        channel = InProcessChannelBuilder.forName(serverName).directExecutor().build();
    }

    @AfterEach
    void tearDown() throws Exception {
        // Shutdown the server and channel after each test
        if (server != null) {
            server.shutdownNow();
        }
        if (channel != null) {
            channel.shutdownNow();
        }
    }

    @Test
    void testClientServerCommunication() {
        // Create a blocking stub to make synchronous gRPC calls
        SenddataGrpc.SenddataBlockingStub stub = SenddataGrpc.newBlockingStub(channel);

        // Build a request for the test
        sendclientserver request = sendclientserver.newBuilder()
                .setFileLocation("test/testInputFile.test") // Specify your test file location here
                .setOutputLocation(sendclientserver.outLocation.print) // or .file if you're testing file output
                .build();

        // Send the request and get the response from the server
        sendresponse response = stub.senddatatoclient(request);

        // Verify the response message
        assertEquals("File accepted. Output Type: print.", response.getMessage());
        System.out.println("Test passed: Received response - " + response.getMessage());
    }
}
