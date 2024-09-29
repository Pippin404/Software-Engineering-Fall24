package apis.ds;

public class DataStorePrototype {
    public static void prototypeCode(DataStore dataStore) {

//        start this process
        StartPrototypeResponse startPrototype = dataStore.startPrototype(new StartPrototypeRequest());

//        send source directory
        ParseInputFileResponse sourceResponse = dataStore.sendInput(new ParseInputFileRequest());

//        send destination directory
        SendOutputResponse destinationResponse = dataStore.sendDestination(new WriteToFileRequest());

//        Choose from the default delimiters if there aren't any included
        if(dataStore.getDelimiterType() == DelimiterInformation.DEFAULT_DELIMITERS) {
            ChooseDefaultDelimitersResponse chooseDelimitersResponse = dataStore.chooseDelimiters(new ChooseDefaultDelimitersRequest());
        } else {
//            send chosen delimiters
            SendDelimitersResponse delimitersResponse = dataStore.sendDelimiters(new SendDelimitersRequest());
        }
    }
}
