package apis.us;

import inputoutput.OutputType;

public class USPrototypeClass {

    
    //This is a prototype class for the US handler
    
    void prototype(UserCommunicatorHandler comm) {
        
        
        //Sets the output to text file
        OutputType out=OutputType.TEXT;
        
        System.out.println(out);
        
        
        //this gets the user input. 
        
        //this should probably do something
        comm.setDelimiters();
        try {
            comm.getUserInput();
        } catch (Exception e) {
            //input not 1
            e.printStackTrace();
        }
        
        
        
    }
    
    
}
