package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputType;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseInputFileRequest  {
//    should include an input config with the file path and the delimiters
    private File inputFile;
    private String delimiter;
    private InputType inputType;

    public List<Integer> parseFile(File inputFile, InputType inputType, Delimiter delimiter) {
        switch (inputType) {
            case CONSOLE:
                break;
            case CSV:
                return csvHandler(inputFile, delimiter);
            case TEXT:
                 break;
            case JSON:
                break;
        }
        return null;
    }
//TODO: Double check with the professor if this is the right format to return the parsed ints. Also ask if this is very very slow.
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


}
