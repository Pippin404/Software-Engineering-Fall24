package us;

import java.util.ArrayList;
import java.util.Scanner;
import apis.us.UserCommunicatorHandler;
import inputoutput.OutputType;

public class InMemoryImplUS implements UserCommunicatorHandler{

  //this should ask for an in memory impel
    //ask user for an item? send it off?
    //I feel like getUserInput should have a scanner at this point.
    //but i'm not sure how that would go
    //MUST ASK!
    
    String outPutLocation=null;
    String inputType=null;
    
    ArrayList<Integer> results = new ArrayList<Integer>();
    
    
    //to get the info from the user
    public int getUserInput() {
        // Scanner and stuff
        //no command line here
        //stores user input
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        results.add(num);
        
        //NEVER FORGET!
        scanner.close();
        
        return num;
    }
    
    
    
    
    public String setOutputType(String s) {
        //gets the output type and stores in in the local variable 
        //System out prints instead of dealing with file writing?
        
        
        return null;
    }
    
    public void outPut(String stringParam) {

        if(outPutLocation==null) {
            //whoops! made an error
            System.out.println(results);
        }else if(outPutLocation=="file"){
            System.out.println("Put it in a file! (lying)");
            
            
        }else {
            //if its ==command (referencing command line)
            System.out.println(results);
        }
        
        
        
        
    }
    
    
    
    
    
    
    //Unused methods

    @Override
    public void outPut(int i) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDelimiters() {
        // TODO Auto-generated method stub
        
    }




    @Override
    public void setOutputType(OutputType outputType) {
        // TODO Auto-generated method stub
        
    }

    
    
    
    
    
    
}
