package ds.unittests;

import org.mockito.Mockito;

import apis.ds.DataStoreInterface;
import apis.ds.DataStorePrototype;




public class DataStoreTest {
    private static final DataStorePrototype dataStorePrototype = new DataStorePrototype();


    public static void main(String[] args) {
        DataStoreInterface mockInput = Mockito.mock(DataStoreInterface.class);
        prototype(mockInput);
    }

    static void prototype(DataStoreInterface dataStoreInterface){
//        not sure if this is how I'm supposed to do it
        DataStorePrototype.prototypeCode(dataStoreInterface);
    }
}
