import apis.data_store.*;
import apis.data_store.DataStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.data_store.ChooseDefaultDelimitersRequest ChooseDefaultDelimitersRequest;
    private Class<? extends apis.data_store.SendSourceRequest> SendSourceRequest;


    @Test
    public void dataStoreTest() {
        DataStore dataStore = Mockito.mock(DataStore.class);

        DataStorePrototype dataStorePrototype = new DataStorePrototype();
        DataStorePrototype.prototypeCode(dataStore);
    }

    @Test
    public void chooseDelimitersTest() {
        ChooseDefaultDelimitersRequest mockChooseDelimitersRequest = Mockito.mock(ChooseDefaultDelimitersRequest.class);

        DataStore.chooseDelimiters(mockChooseDelimitersRequest);
    }

    @Test
    public void sendSourceTest() {
        SendSourceRequest mockSendSourceRequest = Mockito.mock(SendSourceRequest.class);

        DataStore.sendSource(mockSendSourceRequest);
    }

    @Test
    public void sendDestinationTest() {
        SendDestinationRequest mockSendDestinationRequest = Mockito.mock(SendDestinationRequest.class);

        DataStore.sendDestination(mockSendDestinationRequest);
    }

    @Test
    public void getDelimiterTypeTest() {
        DataStore.getDelimiterType();
    }

    @Test
    public void sendDelimitersTest() {
        SendDelimitersRequest mockSendDelimitersRequest = Mockito.mock(SendDelimitersRequest.class);

        DataStore.sendDelimiters(mockSendDelimitersRequest);
    }



}

