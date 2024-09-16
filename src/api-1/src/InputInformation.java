public interface InputInformation {
    SendSourceResponse sendSource(SendSourceRequest sendSourceRequest);

    SendDestinationResponse sendDestination(SendDestinationRequest sendDestinationRequest);

    DelimiterInformation getDelimiterType();

    ChooseDefaultDelimitersResponse chooseDelimiters(ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest);

    SendDelimitersResponse sendDelimiters( SendDelimitersRequest sendDelimitersRequest);
}
