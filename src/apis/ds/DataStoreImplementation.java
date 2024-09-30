package apis.ds;

import inputoutput.Delimiter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataStoreImplementation implements DataStore {

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
    public WriteToFileResponse writeIntegerToFile(WriteToFileRequest writeToFileRequest) {
        return null;
    }

    public ParseInputFileResponse sendInput(ParseInputFileRequest parseInputFileRequest){
        return new ParseInputFileResponse(new ArrayList<>()) {
        };
    }

    public WriteToFileResponse writeToFile(WriteToFileRequest writeToFileRequest){
        return new WriteToFileResponse() {
        };
    }



    public void storeData(int result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest) {
        return new StartPrototypeResponse() {

        };
    }


}
