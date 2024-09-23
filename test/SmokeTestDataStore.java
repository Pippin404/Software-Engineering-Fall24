import apis.data_store.ChooseDefaultDelimitersRequest;
import apis.data_store.DataStorePrototype;
import apis.data_store.SendSourceRequest;
import apis.data_store.SendDestinationRequest;
import apis.data_store.SendDelimitersRequest;
import apis.data_store.DataStore;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.data_store.ChooseDefaultDelimitersRequest ChooseDefaultDelimitersRequest;
    private Class<? extends apis.data_store.SendSourceRequest> SendSourceRequest;


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

