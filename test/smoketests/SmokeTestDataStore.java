package smoketests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import apis.ds.ChooseDefaultDelimitersRequest;
import apis.ds.DataStore;
import apis.ds.DataStorePrototype;
import apis.ds.SendDelimitersRequest;
import apis.ds.SendOutputRequest;
import apis.ds.SendInputRequest;

import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.ds.ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest;
    private Class<? extends SendInputRequest> sendSourceRequest;


    @Test
    public void dataStoreTest() {
        DataStore mockDataStore = mock(DataStore.class);

        DataStorePrototype dataStorePrototype = new DataStorePrototype();
        DataStorePrototype.prototypeCode(mockDataStore);
        Assertions.assertEquals(mockDataStore, null);
    }

    @Test
    public void chooseDelimitersTest() {
        ChooseDefaultDelimitersRequest mockChooseDelimitersRequest = mock(ChooseDefaultDelimitersRequest.class);

        DataStore.chooseDelimiters(mockChooseDelimitersRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendSourceTest() {
        SendInputRequest mockSendInputRequest = mock(SendInputRequest.class);

        DataStore.sendSource(mockSendInputRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendDestinationTest() {
        SendOutputRequest mockSendOutputRequest = mock(SendOutputRequest.class);

        DataStore.sendDestination(mockSendOutputRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void getDelimiterTypeTest() {

        DataStore.getDelimiterType();
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendDelimitersTest() {
        SendDelimitersRequest mockSendDelimitersRequest = mock(SendDelimitersRequest.class);

        DataStore.sendDelimiters(mockSendDelimitersRequest);
        Assertions.assertEquals(DataStore, null);
    }



}

