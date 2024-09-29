package apis.ds;

import java.util.Iterator;

public class DataStoreImplementation implements DataStore {
    @SuppressWarnings("unused")
    private DataStore dataStore;
    @SuppressWarnings("unused")
    private Iterable<Integer> source;
    @SuppressWarnings("unused")
    private WriteToFileResponse destination;

    public Iterable<Integer> read(InputConfig source) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
    }

    public WriteResult appendSingleResult(WriteToFileResponse output, String result){
        return new WriteResult(){

        };
    }

    public ParseInputFileResponse sendInput(ParseInputFileRequest parseInputFileRequest){
        return new ParseInputFileResponse() {
        };
    }

    public SendOutputResponse sendDestination(WriteToFileRequest writeToFileRequest){
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

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }


}
