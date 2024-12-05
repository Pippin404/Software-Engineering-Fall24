package server;

import java.io.File;

import apis.ds.DataStore;
import apis.ds.FileParseRequest;
import apis.ds.FileParseResponse;
import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import io.grpc.stub.StreamObserver;
import protobuf.datastore.CommonEnums.ExternalDelimiter;
import protobuf.datastore.CommonEnums.InputOutputType;
import protobuf.datastore.CommonEnums.ResponseCode;
import protobuf.datastore.ParseFileGrpc;
import protobuf.datastore.ParseInputFile.ParseFileServiceRequest;
import protobuf.datastore.ParseInputFile.ParseFileServiceResponse;
import statuscodes.FileResponseCode;

//TODO: These types are so ugly
public class ParseFileServiceImpl extends ParseFileGrpc.ParseFileImplBase {
    @Override
    public void parseInputFileService(ParseFileServiceRequest serviceRequest,

            // Deeleted the faulty super method that did nothing

            StreamObserver<ParseFileServiceResponse> serviceResponseObserver) {

        // Proto ParseFileServiceRequest -> DataStore internalFileParseRequest to use
        // the internal DataStore logic
        FileParseRequest internalFileParseRequest = convertToInternalRequest(serviceRequest);

        DataStore dataStore = new DataStore();

        // DataStore internalFileParseResponse from using the internal function
        FileParseResponse internalFileParseResponse = dataStore.internalParseInput(internalFileParseRequest);

        // DataStore internalFileParseResponse -> Proto ParseFileServiceResponse to be
        // sent back out through proto
        ParseFileServiceResponse response = convertToProtoResponse(internalFileParseResponse);

        // Send out new proto response
        serviceResponseObserver.onNext(response);
        serviceResponseObserver.onCompleted();

    }

    private FileParseRequest convertToInternalRequest(ParseFileServiceRequest serviceRequest) {
        // Converts the proto response message to the internal request class
        File inputFile = new File(serviceRequest.getInputFile());

        InputType inputType = mapToInternalInputType(serviceRequest.getInputType());
        InputConfig inputConfig = new InputConfig(inputFile, inputType);

        Delimiter delimiter = mapToInternalDelimiter(serviceRequest.getDelimiter());

        return new FileParseRequest(inputConfig, delimiter);
    }

    private ParseFileServiceResponse convertToProtoResponse(FileParseResponse internalResponse) {
        ParseFileServiceResponse.Builder responseBuilder = ParseFileServiceResponse.newBuilder()
                .addAllParsedIntegers(internalResponse.getParsedIntegers())
                .setResponseCode(mapFileResponseCode(internalResponse.getParseInputFileResponseCode()));

        return responseBuilder.build();
    }

    private Delimiter mapToInternalDelimiter(ExternalDelimiter externalDelimiter) {
        return switch (externalDelimiter) {
        case COMMA -> Delimiter.COMMA;
        case SEMICOLON -> Delimiter.SEMICOLON;
        case TAB -> Delimiter.TAB;
        case PIPE -> Delimiter.PIPE;
        default -> throw new IllegalArgumentException("Unknown Delimiter: " + externalDelimiter);
        };
    }

    private InputType mapToInternalInputType(InputOutputType inputOutputType) {
        return switch (inputOutputType) {
        case CONSOLE -> InputType.CONSOLE;
        case CSV -> InputType.CSV;
        case TEXT -> InputType.TEXT;
        case JSON -> InputType.JSON;
        default -> throw new IllegalArgumentException("Unknown InputOutputType: " + inputOutputType);
        };
    }

    // TODO: This shouldn't repeat a response code
    private ResponseCode mapFileResponseCode(FileResponseCode internalCode) {
        return switch (internalCode) {
        case VALID_FILE -> ResponseCode.SUCCESS;
        case INVALID_FILE -> ResponseCode.FAILURE;
        default -> ResponseCode.FAILURE;
        };
    }

}