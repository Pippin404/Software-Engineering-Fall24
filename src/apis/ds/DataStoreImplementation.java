package apis.ds;

import inputoutput.Delimiter;
import inputoutput.OutputConfig;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStoreImplementation implements DataStore {

//    The actual data store itself doesn't store variables, it just processes requests to store them in other places

    @Override
    public ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest) {
//        this is only instantiated to be easier to read
        Delimiter delimiter = parseInputFileRequest.getDelimiter();
        switch (delimiter.getValue()) {
            case "CONSOLE":
                break;
            case "CSV":
//                this is only instantiated to be easier to read
                File inputFile = parseInputFileRequest.getInputFile();

                List<Integer> parsedIntegers = csvHandler(inputFile, delimiter);

//                TODO (Question): Ask if this response would be better off as a class or interface
//                returns the parsed integers to the CE
                return new ParseInputFileResponse(parsedIntegers);

            case "TEXT":
                break;
            case "JSON":
                break;
        }
        return null;
    }

    //TODO (Question): Double check with the professor if this is the right format to return the parsed ints. Also ask if this is very very slow.

    public List<Integer> csvHandler(File inputFile, Delimiter delimiter) {
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
        OutputConfig outputConfig = writeListToFileRequest.getOUTPUT_CONFIG();

        switch (outputConfig.getOUTPUT_TYPE()) {
            case CSV -> {

            }
            case JSON -> {

            }
            case TEXT -> {

            }
            case CONSOLE -> {

            }
        }
        return null;
    }

    public WriteListToFileResponse writeToTextHandler(Path outputFilePath, String outputFileName, List<Integer> computedIntegers) {
        return null;
    }


    @Override
    public WriteIntegerToFileResponse writeIntegerToFile(WriteIntegerToFileRequest writeIntegerToFileRequest) {
//        instantiated to be more readable
        OutputConfig outputConfig = writeIntegerToFileRequest.getOUTPUT_CONFIG();
        int computedInteger = writeIntegerToFileRequest.getComputedInteger();

        switch (outputConfig.getOUTPUT_TYPE()) {
            case CSV -> {

            }
            case JSON -> {

            }
            case TEXT -> {
                writeToTextHandler(outputConfig.getOUTPUT_PATH(), computedInteger);
            }
            case CONSOLE -> {

            }
        }
        return null;
    }

    public WriteIntegerToFileResponse writeToTextHandler(String outputFilePath, int computedInteger) {
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
