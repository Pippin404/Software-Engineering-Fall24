import apis.datastore.ChooseDefaultDelimitersRequest;
import apis.datastore.DataStorePrototype;
import apis.datastore.SendSourceRequest;
import apis.datastore.SendDestinationRequest;
import apis.datastore.SendDelimitersRequest;
import apis.datastore.DataStore;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.datastore.ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest;
    private Class<? extends apis.datastore.SendSourceRequest> sendSourceRequest;


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

