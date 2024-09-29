package apis.us;

public class UserCommunicatorImpl implements UserCommunicatorHandler{

    OutputType output=OutputType.CONSOLE;
    String outPutLocation=null;
    String inputType=null;
    //SEE THE UserCommHandler TO FIND OUT WHAT THESE DO!!!
    
    
    @Override
    public void getUserInput() {
        System.out.println("User input retrieved");
        
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