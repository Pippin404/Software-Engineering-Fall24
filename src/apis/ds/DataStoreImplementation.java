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

    @Override
    public WriteToFileRequest appendSingleResult(WriteToFileResponse output, String result) {
        return null;
    }

    @Override
    public ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest) {
        return null;
    }

    @Override
    public WriteToFileResponse writeIntegerToFile(WriteToFileRequest writeToFileRequest) {
        return null;
    }

    public ParseInputFileResponse sendInput(ParseInputFileRequest parseInputFileRequest){
        return new ParseInputFileResponse() {
        };
    }

    public WriteToFileResponse writeToFile(WriteToFileRequest writeToFileRequest){
        return new WriteToFileResponse() {
        };
    }



    public void storeData(int result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }


}
