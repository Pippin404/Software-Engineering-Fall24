package apis.ds;

import java.util.Iterator;

public class DataStoreImplementation implements DataStore {
    @SuppressWarnings("unused")
    private DataStore dataStore;
    @SuppressWarnings("unused")
    private Iterable<Integer> source;
    @SuppressWarnings("unused")
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

    @Override
    public void storeData(int result) {
        // TODO Auto-generated method stub
        
    }



}
