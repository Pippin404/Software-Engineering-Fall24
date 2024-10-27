package apis.us;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import inputoutput.OutputType;


@SuppressWarnings("unused")
public class UserCommunicatorImpl implements UserCommunicatorHandler{

    OutputType output=OutputType.CONSOLE;
    String outPutLocation=null;
    String inputType=null;
    int data=5;
    
    //SEE THE UserCommHandler TO FIND OUT WHAT THESE DO!!!
    
    // reads a file of integers seperated by commas and stores then in List<Integer> which it returns
    public List<Integer> readFile(File file) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas, trim whitespace, and parse each element as an integer
                String[] values = line.split(",");
                for (String value : values) {
                    numbers.add(Integer.parseInt(value.trim()));
                }
            }
            System.out.println("Numbers read from file: " + numbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbers;
    }
    
    
    
    
    @Override
    public int getUserInput() throws Exception {
        
        /*//NOT RIGHT NOW!!
        //scanner here
        //will be more complicated later. this is just for now
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        
        //Small change to attempt to publish branch
        
        //NEVER FORGET!
        scanner.close();
        System.out.println("User input retrieved");
        return num;
        */
        int input=3;
        
        if(input<=0) {
           throw new Exception("Error! User input needs to be >1");
        }
        
        
        this.data=5;
        return 5;
    }
    @Override
    public void setDelimiters() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void setOutputType(OutputType out) {
        //This sets the outputType of the function, using the enum OutputType previously declared   
        output=out;
        
    }
    @Override
    public void outPut(String stringParam) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void outPut(int i) {
        // TODO Auto-generated method stub
        
    }
    
 
    
    
    

}
