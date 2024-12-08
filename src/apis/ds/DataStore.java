package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputType;
import inputoutput.OutputType;
import statuscodes.BasicResponseCode;
import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;
import statuscodes.ParameterResponseCode;

public class DataStore implements DataStoreInterface {

    // the implementation of other apis might handle the passing of data differently
    // and need to access it like this
    private List<Integer> data;

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public FileParseResponse internalParseInput(FileParseRequest request) {
        try {
//            FIX: this should be switching on inputType not delimiter
            InputType inputType = request.getInputType();
            switch (inputType.getValue()) {
            case "CONSOLE":
                break;
            case "CSV":
//                this is only instantiated to be easier to read

                    Delimiter delimiter = request.getDelimiter();
                    File inputFile = request.getInputFile();


                List<Integer> parsedIntegers = csvHandler(inputFile, delimiter);


                    //returns the parsed integers to the CE
                    return FileParseResponse.builder().parsedIntegers(parsedIntegers).fileResponseCode(FileResponseCode.VALID_FILE).build();
                case "TEXT":
                    break;
                case "JSON":
                    break;
                default:
                    break;

            }

        } catch (Exception e) {
            System.out.println("Uncaught exception in API boundary.");
            e.printStackTrace();
        }
//        TODO: This is causing a bug where the ParseInputFileResponse is always empty, find a way to have it be returned in the try catch only
        return FileParseResponse.builder().parsedIntegers(null).fileResponseCode(FileResponseCode.INVALID_DELIMITERS).build();
    }

//    Handler methods are private because they should only be called by other methods in the class. They rely on processed information that should only be passed if the requests pass certain checks

    // TODO Assignment 8: Make sure that buffered reader is the right library to
    // use. another one might be better for performance
    // TODO: Assignment 8: This should also probably be handled by a stream
    private List<Integer> csvHandler(File inputFile, Delimiter delimiter) {
        List<Integer> parsedIntegers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter.getValue());

                List<Integer> intValues = Arrays.asList(values).stream()
//                        convert to doubles
                        .map(Double::parseDouble)
//                        convert to ints
                        .map(Double::intValue).toList();
                parsedIntegers.addAll(intValues);
            }
            return parsedIntegers;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("File not found!");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public WriteListToFileResponse writeListToFile(WriteListToFileRequest request) {
        try {
            OutputType outputType = request.getOutputType();


            switch (outputType) {
                case CSV: {
                    break;
                }
                case JSON: {
                    break;
                }
                case TEXT: {
                    break;
                }
                case CONSOLE: {
                    break;
                }
                default: {
                    break;
                }


            }
        } catch (Exception e) {
            System.out.println("Uncaught exception in API boundary.");
            e.printStackTrace();
        }
//        TODO: Should not return null
        return null;
    }

    private WriteListToFileResponse writeToTextHandler(Path outputFilePath, String outputFileName,
            List<Integer> computedIntegers) {
        return null;
    }

    @Override
    public InternalWriteIntegerResponse internalWriteInteger(InternalWriteIntegerRequest request) {
        try {

            //instantiated to be more readable
            OutputType outputType = request.getOutputType();
            String outputPath = request.getOutputPath();
            int computedInteger = request.getComputedInteger();

            switch (outputType) {
                case CSV: {
                    break;
                }
                case JSON: {
                    break;
                }
                case TEXT: {
                    writeToTextHandler(outputPath, computedInteger);
                    break;
                }
                case CONSOLE: {
                    break;
                }
                default: {
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Uncaught exception in API boundary.");
            e.printStackTrace();
        }

        return InternalWriteIntegerResponse.builder().fileResponseCode(FileResponseCode.INTEGER_NOT_WRITTEN).build();

    }

    // TODO Assignment 8: This should be done through a stream, and FileWriter might
    // be better off as BufferedWriter
    private InternalWriteIntegerResponse writeToTextHandler(String outputFilePath, int computedInteger) {
        File file = new File(outputFilePath);
        FileWriter writer = null;
        try {
            // Makes the new file or adds to it if it already exists
            writer = new FileWriter(file, true);
            // Add data and a new line to the file
            writer.write(computedInteger + "\n");
            // Catch any error, throw exception
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file writer: " + e.getMessage());
            }
        }

        return InternalWriteIntegerResponse.builder().fileResponseCode(FileResponseCode.INTEGER_WRITTEN).build();
    }

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }

}
