package apis.ds;

public interface DataStore {
    Iterable<Integer> read(InputConfig source);
    WriteResult appendSingleResult(DestinationConfig output, String result);

    SendInputResponse sendSource(SendInputRequest sendInputRequest);

    SendOutputResponse sendDestination(SendOutputRequest sendOutputRequest);

    DelimiterInformation getDelimiterType();

    ChooseDefaultDelimitersResponse chooseDelimiters(ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest);

    SendDelimitersResponse sendDelimiters(SendDelimitersRequest sendDelimitersRequest);
    void storeData(int result);//hey so internal computing engineTest sent this here, 
                                //im just trying to get this to pass gradle :Pippin, 9/27/24 2:30pm
}
