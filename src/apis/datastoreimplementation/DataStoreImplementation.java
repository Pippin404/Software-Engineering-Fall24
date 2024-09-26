package apis.datastoreimplementation;

import apis.datastore.ChooseDefaultDelimitersRequest;
import apis.datastore.SendSourceRequest;
import apis.datastore.SendDestinationRequest;
import apis.datastore.SendDelimitersRequest;
import apis.datastore.DataStore;
import apis.datastore.DestinationConfig;
import apis.datastore.SourceConfig;
import apis.datastore.WriteResult;
import apis.datastore.SendSourceResponse;
import apis.datastore.SendDestinationResponse;
import apis.datastore.DelimiterInformation;
import apis.datastore.ChooseDefaultDelimitersResponse;
import apis.datastore.SendDelimitersResponse;

import java.util.Iterator;

public class DataStoreImplementation implements DataStore {
    private DataStore dataStore;
    private Iterable<Integer> source;
    private DestinationConfig destination;

    public Iterable<Integer> read(SourceConfig source) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
    }

    public WriteResult appendSingleResult(DestinationConfig output, String result){
        return new WriteResult(){

        };
    }

    public SendSourceResponse sendSource(SendSourceRequest sendSourceRequest){
        return new SendSourceResponse() {
        };
    }

    public SendDestinationResponse sendDestination(SendDestinationRequest sendDestinationRequest){
        return new SendDestinationResponse() {
        };
    }

    public DelimiterInformation getDelimiterType(){
        return DelimiterInformation.CHOSEN_DELIMITERS;
    }

    public ChooseDefaultDelimitersResponse chooseDelimiters(ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest){
        return new ChooseDefaultDelimitersResponse() {
        };
    }

    public SendDelimitersResponse sendDelimiters(SendDelimitersRequest sendDelimitersRequest){
        return new SendDelimitersResponse() {
        };
    }



}
