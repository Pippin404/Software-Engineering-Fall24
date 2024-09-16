public class Prototype {
    public static void prototypeCode(InputInformation input) {

//        send source directory
        SendSourceResponse sourceResponse = input.sendSource(new SendSourceRequest());

//        send destination directory
        SendDestinationResponse destinationResponse = input.sendDestination(new SendDestinationRequest());

//        Choose from the default delimiters if there aren't any included
        if(input.getDelimiterType() == DelimiterInformation.DEFAULT_DELIMITERS) {
            ChooseDefaultDelimitersResponse chooseDelimitersResponse = input.chooseDelimiters(new ChooseDefaultDelimitersRequest());
        } else {
//            send chosen delimiters
            SendDelimitersResponse delimitersResponse = input.sendDelimiters(new SendDelimitersRequest());
        }
    }
}
