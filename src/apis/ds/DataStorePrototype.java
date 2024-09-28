package apis.ds;

public class DataStorePrototype {
    public static void prototypeCode(DataStore dataStore) {

//        send source directory
        SendInputResponse sourceResponse = dataStore.sendInput(new SendInputRequest());

//        send destination directory
        SendOutputResponse destinationResponse = dataStore.sendDestination(new SendOutputRequest());

//        Choose from the default delimiters if there aren't any included
        if(dataStore.getDelimiterType() == DelimiterInformation.DEFAULT_DELIMITERS) {
            ChooseDefaultDelimitersResponse chooseDelimitersResponse = dataStore.chooseDelimiters(new ChooseDefaultDelimitersRequest());
        } else {
//            send chosen delimiters
            SendDelimitersResponse delimitersResponse = dataStore.sendDelimiters(new SendDelimitersRequest());
        }
    }
}
