package apis.us;

public interface UserCommHandler {

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
    
    public String setOutputType(String s);
    //output to command line
    //Or a file
    //IF ITS A FILE, RETURN FILENAME??
    
    
    public void outPut(String S);
    //Outputs if its a string
    //goes where setOutputType wants it
    //need a variable to control that?
    
    public void outPut(int i);
    //method overloading to also accept strings
    //just do above but cast to a string
    
    
}
