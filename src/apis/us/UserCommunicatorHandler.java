package apis.us;

import inputoutput.OutputType;

public interface UserCommunicatorHandler {

    OutputType output=OutputType.CONSOLE;
    String outPutLocation=null;
    String inputType=null;
    //file or command line or scanner.
    
    
    
    public void getUserInput();
    //MAKE SURE setOutPut type is set??
    //if outPutLocation==null, set it to system.out.println
    //if inputType (Delimiters) is not set, call it to make it up!!
    //available options
    //scanner
    //command line
    //???
    
    
    
    public void setDelimiters();
    //prompt the user for delimiters
    //SETS INPUT TYPE
    //Use overflowing
    
    public void setOutputType(OutputType outputType);
    //output to command line
    //Or a file
    //IF ITS A FILE, RETURN FILENAME??
    
    
    public void outPut(String stringParam);
    //Outputs if its a string
    //goes where setOutputType wants it
    //Either to a file, CSV, or prints it out in the console
    
    
    
    public void outPut(int i);
    //method overloading to also accept strings
    //just do above but cast to a string
    
    
}
