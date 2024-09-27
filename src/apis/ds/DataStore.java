package apis.ds;

public interface DataStore {
    Iterable<Integer> read(SourceConfig source);
    WriteResult appendSingleResult(DestinationConfig output, String result);

    SendSourceResponse sendSource(SendSourceRequest sendSourceRequest);

    SendDestinationResponse sendDestination(SendDestinationRequest sendDestinationRequest);

    DelimiterInformation getDelimiterType();

    ChooseDefaultDelimitersResponse chooseDelimiters(ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest);

    SendDelimitersResponse sendDelimiters(SendDelimitersRequest sendDelimitersRequest);
    void storeData(int result);//hey so internal computing engineTest sent this here, 
                                //im just trying to get this to pass gradle :Pippin, 9/27/24 2:30pm
}
