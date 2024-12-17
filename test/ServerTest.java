import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;
import server.ClientServer;
import server.ParseFileServiceImpl;

public class ServerTest {

    private ManagedChannel channel;
    private ManagedChannel clientChannel;
    private io.grpc.Server clientServer;
    private io.grpc.Server parseFileServer;

    @BeforeEach
    void setup() throws Exception {
        String parseFileServerName = "parseFileServer";
        String clientServerName = "clientServer";

        parseFileServer = InProcessServerBuilder.forName(parseFileServerName)
                .directExecutor()
                .addService(new ParseFileServiceImpl())
                .build()
                .start();

        clientServer = InProcessServerBuilder.forName(clientServerName)
                .directExecutor()
                .addService(new ClientServer())
                .build()
                .start();

        channel = InProcessChannelBuilder.forName(parseFileServerName).directExecutor().build();
        this.clientChannel = InProcessChannelBuilder.forName(clientServerName).directExecutor().build();
    }

    @AfterEach
    void tearDown() throws Exception {
        if (parseFileServer != null) {
            parseFileServer.shutdownNow();
            parseFileServer.awaitTermination(5, TimeUnit.SECONDS);
        }

        if (clientServer != null) {
            clientServer.shutdownNow();
            clientServer.awaitTermination(5, TimeUnit.SECONDS);
        }

        if (channel != null) {
            channel.shutdownNow();
            channel.awaitTermination(5, TimeUnit.SECONDS);
        }

        if (clientChannel != null) {
            clientChannel.shutdownNow();
            clientChannel.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    @Test
    void testClientServerCommunication() {
        // Use the clientChannel for the ClientServer service
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
