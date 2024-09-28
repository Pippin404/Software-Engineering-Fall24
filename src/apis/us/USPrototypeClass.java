package apis.us;

public class USPrototypeClass {

    
    //This is a prototype class for the US handler
    
    void prototype(UserCommHandler comm) {
        
        
        //Sets the output to file
        String outputType=comm.setOutputType("file");
        
        System.out.println(outputType);
        
        
        //this gets the user input. 
        
        //this should probably do something
        comm.setDelimiters();
        
        
        comm.getUserInput();
        
        
        
    }
    
    
}
