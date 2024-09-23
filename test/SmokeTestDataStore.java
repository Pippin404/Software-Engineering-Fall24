import apis.data_store.*;
import apis.data_store.InputInformation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SmokeTestDataStore {

    private static apis.data_store.InputInformation InputInformation;
    private apis.data_store.ChooseDefaultDelimitersRequest ChooseDefaultDelimitersRequest;
    private Class<? extends apis.data_store.SendSourceRequest> SendSourceRequest;


    @Test
    public void dataStoreTest() {
        InputInformation mockInput = Mockito.mock(InputInformation);

        DataStoreAPI dataStore = new DataStoreAPI();
        DataStoreAPI.prototypeCode(mockInput);
    }

    @Test
    public void chooseDelimitersTest() {
        ChooseDefaultDelimitersRequest mockChooseDelimitersRequest = Mockito.mock(ChooseDefaultDelimitersRequest.class);

        InputInformation.chooseDelimiters(mockChooseDelimitersRequest);
    }

    @Test
    public void sendSourceTest() {
        SendSourceRequest mockSendSourceRequest = Mockito.mock(SendSourceRequest.class);

        InputInformation.sendSource(mockSendSourceRequest);
    }

    @Test
    public void sendDestinationTest() {
        SendDestinationRequest mockSendDestinationRequest = Mockito.mock(SendDestinationRequest.class);

        InputInformation.sendDestination(mockSendDestinationRequest);
    }

    @Test
    public void getDelimiterTypeTest() {
        InputInformation.getDelimiterType();
    }

    @Test
    public void sendDelimitersTest() {
        SendDelimitersRequest mockSendDelimitersRequest = Mockito.mock(SendDelimitersRequest.class);

        InputInformation.sendDelimiters(mockSendDelimitersRequest);
    }



}

