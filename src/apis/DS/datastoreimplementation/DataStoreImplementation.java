package apis.datastoreimplementation;

import java.util.Iterator;

import apis.DS.ChooseDefaultDelimitersRequest;
import apis.DS.ChooseDefaultDelimitersResponse;
import apis.DS.DataStore;
import apis.DS.DelimiterInformation;
import apis.DS.DestinationConfig;
import apis.DS.SendDelimitersRequest;
import apis.DS.SendDelimitersResponse;
import apis.DS.SendDestinationRequest;
import apis.DS.SendDestinationResponse;
import apis.DS.SendSourceRequest;
import apis.DS.SendSourceResponse;
import apis.DS.SourceConfig;
import apis.DS.WriteResult;

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
