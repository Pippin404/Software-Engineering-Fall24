package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import statuscodes.BasicResponseCode;
import statuscodes.ParameterResponseCode;
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
    private List<Integer> data;

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public FileParseResponse internalParseInput(FileParseRequest fileParseRequest) {
        try {
//            FIX: this should be switching on inputType not delimiter
            InputType inputType = fileParseRequest.getInputConfig().getInputType();
            switch (inputType.getValue()) {
                case "CONSOLE":
                    break;
                case "CSV":
//                this is only instantiated to be easier to read
                    InputConfig inputConfig = fileParseRequest.getInputConfig();

                    Delimiter delimiter = fileParseRequest.getDelimiter();


                    File inputFile = inputConfig.getInputFile();

                    FileResponseCode fileResponseCode = fileParseRequest.getParseInputFileResponseCode();
                    ParameterResponseCode parameterResponseCode = fileParseRequest.getBasicResponseCode();

                    List<Integer> parsedIntegers = csvHandler(inputFile, delimiter);

//                returns the parsed integers to the CE
                    return new FileParseResponse(parsedIntegers, fileResponseCode, parameterResponseCode);
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
        return new FileParseResponse();
    }



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
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest) {
        try {
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
        } catch(Exception e) {
            System.out.println("Uncaught exception in API boundary.");
            e.printStackTrace();
        }
//        TODO: Should not return null
        return null;
    }

    private WriteListToFileResponse writeToTextHandler(Path outputFilePath, String outputFileName, List<Integer> computedIntegers) {
        return null;
    }


    @Override
    public WriteIntegerResponse internalWriteInteger(WriteIntegerRequest writeIntegerRequest) {
        try {
            //        instantiated to be more readable
            OutputConfig outputConfig = writeIntegerRequest.getOutputConfig();
            int computedInteger = writeIntegerRequest.getComputedInteger();

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

        } catch(Exception e) {
            System.out.println("Uncaught exception in API boundary.");
            e.printStackTrace();
        }
        //        TODO: bad, unfinished, add implementation
        return new WriteIntegerResponse(BasicResponseCode.FAILURE);
    }

    private WriteIntegerResponse writeToTextHandler(String outputFilePath, int computedInteger) {
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

        return new WriteIntegerResponse(BasicResponseCode.SUCCESS);
    }

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }


}
