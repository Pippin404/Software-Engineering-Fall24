package apis.data_store;

public interface DataStore {
    Iterable<Integer> read(SourceConfig source);
    WriteResult appendSingleResult(DestinationConfig output, String result);

    SendSourceResponse sendSource(SendSourceRequest sendSourceRequest);

    SendDestinationResponse sendDestination(SendDestinationRequest sendDestinationRequest);

    DelimiterInformation getDelimiterType();

    ChooseDefaultDelimitersResponse chooseDelimiters(ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest);

    SendDelimitersResponse sendDelimiters(SendDelimitersRequest sendDelimitersRequest);
}
