package apis;

import apis.data_store.DataStoreAPI;
import apis.data_store.InputInformation;

import org.mockito.Mockito;




public class DataStoreTest {
    private static final DataStoreAPI dataStoreAPI = new DataStoreAPI();


    public static void main(String[] args) {
        InputInformation mockInput = Mockito.mock(InputInformation.class);
        prototype(mockInput);
    }

    static void prototype(InputInformation inputInformation){
//        not sure if this is how I'm supposed to do it
        DataStoreTest.dataStoreAPI.prototypeCode(inputInformation);
    }
}
