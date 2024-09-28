package apis.ds;

import java.util.Iterator;

public class DataStoreImplementation implements DataStore {
    @SuppressWarnings("unused")
    private DataStore dataStore;
    @SuppressWarnings("unused")
    private Iterable<Integer> source;
    @SuppressWarnings("unused")
    private OutputConfig destination;

    public Iterable<Integer> read(InputConfig source) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
    }

    public WriteResult appendSingleResult(OutputConfig output, String result){
        return new WriteResult(){

        };
    }

    public SendInputResponse sendInput(SendInputRequest sendInputRequest){
        return new SendInputResponse() {
        };
    }

    public SendOutputResponse sendDestination(SendOutputRequest sendOutputRequest){
        return new SendOutputResponse() {
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
