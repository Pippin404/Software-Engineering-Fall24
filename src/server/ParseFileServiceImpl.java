package server;

import apis.ds.DataStore;
import datastore.CommonEnums;
import datastore.ParseFileGrpc;
import datastore.ParseInputFile;
import inputoutput.InputType;
import io.grpc.stub.StreamObserver;
import apis.ds.FileParseRequest;
import apis.ds.FileParseResponse;
import inputoutput.InputConfig;
import inputoutput.Delimiter;

import statuscodes.FileResponseCode;
import statuscodes.ParameterResponseCode;

import java.io.File;

//TODO: These types are so ugly
public class ParseFileServiceImpl extends ParseFileGrpc.ParseFileImplBase {
    @Override
    public void parseInputFileService(ParseInputFile.ParseFileServiceRequest serviceRequest, StreamObserver<ParseInputFile.ParseFileServiceResponse> serviceResponseObserver) {
        super.parseInputFileService(serviceRequest, serviceResponseObserver);

        //Proto ParseFileServiceRequest -> DataStore internalFileParseRequest to use the internal DataStore logic
        FileParseRequest internalFileParseRequest = convertToInternalRequest(serviceRequest);

        DataStore dataStore = new DataStore();

        //DataStore internalFileParseResponse from using the internal function
        FileParseResponse internalFileParseResponse = dataStore.internalParseInput(internalFileParseRequest);

        //DataStore internalFileParseResponse -> Proto ParseFileServiceResponse to be sent back out through proto
        ParseInputFile.ParseFileServiceResponse response = convertToProtoResponse(internalFileParseResponse);

        //Send out new proto response
        serviceResponseObserver.onNext(response);
        serviceResponseObserver.onCompleted();

    }

    private FileParseRequest convertToInternalRequest(ParseInputFile.ParseFileServiceRequest serviceRequest) {
        //Converts the proto response message to the internal request class
        File inputFile = new File(serviceRequest.getInputFile());

        InputType inputType = mapToInternalInputType(serviceRequest.getInputType());
        InputConfig inputConfig = new InputConfig(inputFile, inputType);

        Delimiter delimiter = mapToInternalDelimiter(serviceRequest.getDelimiter());

        return new FileParseRequest(inputConfig, delimiter);
    }

    private ParseInputFile.ParseFileServiceResponse convertToProtoResponse(FileParseResponse internalResponse) {
        ParseInputFile.ParseFileServiceResponse.Builder responseBuilder = ParseInputFile.ParseFileServiceResponse.newBuilder()
                .addAllParsedIntegers(internalResponse.getParsedIntegers())
                .setResponseCode(mapFileResponseCode(internalResponse.getParseInputFileResponseCode()));

        return responseBuilder.build();
    }

    private Delimiter mapToInternalDelimiter(CommonEnums.Delimiter externalDelimiter) {
        switch (externalDelimiter) {
            case COMMA:
                return Delimiter.COMMA;
            case SEMICOLON:
                return Delimiter.SEMICOLON;
            case TAB:
                return Delimiter.TAB;
            case PIPE:
                return Delimiter.PIPE;
            default:
                throw new IllegalArgumentException("Unknown Delimiter: " + externalDelimiter);
        }
    }

    private InputType mapToInternalInputType(CommonEnums.InputOutputType inputOutputType) {
        switch (inputOutputType) {
            case CONSOLE:
                return InputType.CONSOLE;
            case CSV:
                return InputType.CSV;
            case TEXT:
                return InputType.TEXT;
            case JSON:
                return InputType.JSON;
            default:
                throw new IllegalArgumentException("Unknown InputOutputType: " + inputOutputType);
        }
    }

    private CommonEnums.ResponseCode mapFileResponseCode(FileResponseCode internalCode) {
        switch (internalCode) {
            case VALID_FILE:
                return CommonEnums.ResponseCode.SUCCESS;
            case INVALID_FILE:
                return CommonEnums.ResponseCode.FAILURE;
            default:
                return CommonEnums.ResponseCode.FAILURE;
        }
    }


}