package smokeTests;
import org.junit.jupiter.api.Test;

import apis.DS.ChooseDefaultDelimitersRequest;
import apis.DS.DataStore;
import apis.DS.DataStorePrototype;
import apis.DS.SendDelimitersRequest;
import apis.DS.SendDestinationRequest;
import apis.DS.SendSourceRequest;

import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.DS.ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest;
    private Class<? extends apis.DS.SendSourceRequest> sendSourceRequest;


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

