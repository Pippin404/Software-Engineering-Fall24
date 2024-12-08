package server;

import apis.ds.DataStore;
import com.google.protobuf.ByteString;
import inputoutput.OutputType;
import protobuf.datastore.CommonEnums;
import protobuf.datastore.WriteIntegerGrpc;
import protobuf.datastore.WriteIntegerToFile.WriteIntegerServiceRequest;
import protobuf.datastore.WriteIntegerToFile.WriteIntegerServiceResponse;
import inputoutput.OutputConfig;
import io.grpc.stub.StreamObserver;
import apis.ds.InternalWriteIntegerResponse;
import apis.ds.InternalWriteIntegerRequest;
import protobuf.datastore.CommonEnums.ResponseCode;
import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

import java.io.File;

public class WriteIntegerServiceImpl extends WriteIntegerGrpc.WriteIntegerImplBase {
    @Override
    public void writeIntegerService(WriteIntegerServiceRequest serviceRequest, StreamObserver<WriteIntegerServiceResponse> serviceResponseObserver) {
        super.writeIntegerService(serviceRequest, serviceResponseObserver);

        //External Proto request -> Internal Datastore request
        InternalWriteIntegerRequest internalWriteRequest = convertToInternalRequest(serviceRequest);

        //Internal Datastore response -> Internal Datastore response
        DataStore dataStore = new DataStore();
        InternalWriteIntegerResponse internalWriteResponse = dataStore.internalWriteInteger(internalWriteRequest);

        //Internal Datastore response -> External Proto response
        WriteIntegerServiceResponse response = convertToProtoResponse(internalWriteResponse);

        //Send the response back to the client
        serviceResponseObserver.onNext(response);
        serviceResponseObserver.onCompleted();
    }

    private WriteIntegerServiceResponse convertToProtoResponse(InternalWriteIntegerResponse internalWriteResponse) {
        WriteIntegerServiceResponse.Builder responseBuilder = WriteIntegerServiceResponse.newBuilder()
                .setResponseCode(mapResponseCode(internalWriteResponse.getFileResponseCode()));

        return responseBuilder.build();
    }

    private InternalWriteIntegerRequest convertToInternalRequest(WriteIntegerServiceRequest serviceRequest) {
        int computedInteger = serviceRequest.getComputedInteger();
        String outputPath = serviceRequest.getOutputFile();
        OutputType outputType = mapToInternalInputType(serviceRequest.getOutputType());

        return InternalWriteIntegerRequest.builder().computedInteger(computedInteger).outputPath(outputPath).outputType(outputType).build();
    }

    private OutputType mapToInternalInputType(CommonEnums.InputOutputType inputOutputType) {
        // Maps the Proto InputOutputType to internal InputType
        return switch (inputOutputType) {
            case CONSOLE -> OutputType.CONSOLE;
            case CSV -> OutputType.CSV;
            case TEXT -> OutputType.TEXT;
            case JSON -> OutputType.JSON;
            default -> throw new IllegalArgumentException("Unknown InputOutputType: " + inputOutputType);
        };
    }

    private ResponseCode mapResponseCode(FileResponseCode internalResponseCode) {
        // Maps the internal response code to the Proto ResponseCode
        if (internalResponseCode.success()) {
            return ResponseCode.SUCCESS;
        } else {
            return ResponseCode.FAILURE;
        }
    }

}