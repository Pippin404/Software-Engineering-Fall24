package apis.data_store;

public class DataStorePrototype {
    public static void prototypeCode(DataStore dataStore) {

//        send source directory
        SendSourceResponse sourceResponse = dataStore.sendSource(new SendSourceRequest());

//        send destination directory
        SendDestinationResponse destinationResponse = dataStore.sendDestination(new SendDestinationRequest());

//        Choose from the default delimiters if there aren't any included
        if(dataStore.getDelimiterType() == DelimiterInformation.DEFAULT_DELIMITERS) {
            ChooseDefaultDelimitersResponse chooseDelimitersResponse = dataStore.chooseDelimiters(new ChooseDefaultDelimitersRequest());
        } else {
//            send chosen delimiters
            SendDelimitersResponse delimitersResponse = dataStore.sendDelimiters(new SendDelimitersRequest());
        }
    }
}
