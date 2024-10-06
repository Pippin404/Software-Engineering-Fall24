package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.OutputConfig;
import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore implements DataStoreInterface {

//    the implementation of other apis might handle the passing of data differently and need to access it like this
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest) {
//        this is only instantiated to be easier to read
        Delimiter delimiter = parseInputFileRequest.getDelimiter();
        switch (delimiter.getValue()) {
            case "CONSOLE":
                break;
            case "CSV":
//                this is only instantiated to be easier to read
                InputConfig inputConfig = parseInputFileRequest.getInputConfig();

                File inputFile = inputConfig.getInputFile();


                FileResponseCode fileResponseCode = parseInputFileRequest.getParseInputFileResponseCode();
                BasicResponseCode basicResponseCode = parseInputFileRequest.getBasicResponseCode();

                List<Integer> parsedIntegers = csvHandler(inputFile, delimiter);

//                returns the parsed integers to the CE
                return new ParseInputFileResponse(parsedIntegers, fileResponseCode, basicResponseCode);

            case "TEXT":
                break;
            case "JSON":
                break;
            default:
                break;
        }
        return null;
    }

    //TODO (Question): Double check with the professor if this is the right format to return the parsed ints. Also ask if this is very very slow.

//    Handler methods are private because they should only be called by other methods in the class. They rely on processed information that should only be passed if the requests pass certain checks

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
                        .map(Double::intValue)
                        .toList();
                parsedIntegers.addAll(intValues);
            }
            return parsedIntegers;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("File not found!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest) {
        OutputConfig outputConfig = writeListToFileRequest.getOutputConfig();

        switch (outputConfig.getOutputType()) {
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
        return null;
    }

    private WriteListToFileResponse writeToTextHandler(Path outputFilePath, String outputFileName, List<Integer> computedIntegers) {
        return null;
    }


    @Override
    public WriteIntegerToFileResponse writeIntegerToFile(WriteIntegerToFileRequest writeIntegerToFileRequest) {
//        instantiated to be more readable
        OutputConfig outputConfig = writeIntegerToFileRequest.getOutputConfig();
        int computedInteger = writeIntegerToFileRequest.getComputedInteger();

        switch (outputConfig.getOutputType()) {
            case CSV: {
                break;
            }
            case JSON: {
                break;
            }
            case TEXT: {
                writeToTextHandler(outputConfig.getOutputPath(), computedInteger);
                break;
            }
            case CONSOLE: {
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    private WriteIntegerToFileResponse writeToTextHandler(String outputFilePath, int computedInteger) {
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

//        TODO: just returns null for now
        return null;
    }

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }


}
