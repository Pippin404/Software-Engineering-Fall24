package smoketests;
import org.junit.jupiter.api.Test;

import apis.ds.ChooseDefaultDelimitersRequest;
import apis.ds.DataStore;
import apis.ds.DataStorePrototype;
import apis.ds.SendDelimitersRequest;
import apis.ds.SendDestinationRequest;
import apis.ds.SendSourceRequest;

import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.ds.ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest;
    private Class<? extends apis.ds.SendSourceRequest> sendSourceRequest;


    @Test
    public void dataStoreTest() {
        DataStore mockDataStore = mock(DataStore.class);

        DataStorePrototype dataStorePrototype = new DataStorePrototype();
        DataStorePrototype.prototypeCode(mockDataStore);
    }

    @Test
    public void chooseDelimitersTest() {
        ChooseDefaultDelimitersRequest mockChooseDelimitersRequest = mock(ChooseDefaultDelimitersRequest.class);

        DataStore.chooseDelimiters(mockChooseDelimitersRequest);
    }

    @Test
    public void sendSourceTest() {
        SendSourceRequest mockSendSourceRequest = mock(SendSourceRequest.class);

        DataStore.sendSource(mockSendSourceRequest);
    }

    @Test
    public void sendDestinationTest() {
        SendDestinationRequest mockSendDestinationRequest = mock(SendDestinationRequest.class);

        DataStore.sendDestination(mockSendDestinationRequest);
    }

    @Test
    public void getDelimiterTypeTest() {
        DataStore.getDelimiterType();
    }

    @Test
    public void sendDelimitersTest() {
        SendDelimitersRequest mockSendDelimitersRequest = mock(SendDelimitersRequest.class);

        DataStore.sendDelimiters(mockSendDelimitersRequest);
    }



}

