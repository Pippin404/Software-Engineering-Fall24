package apis.us;


import java.util.Scanner;

public class UserCommunicatorImpl implements UserCommunicatorHandler{

    OutputType output=OutputType.CONSOLE;
    String outPutLocation=null;
    String inputType=null;
    
    //SEE THE UserCommHandler TO FIND OUT WHAT THESE DO!!!
    
    
    @Override
    public int getUserInput() {
        
        /*//NOT RIGHT NOW!!
        //scanner here
        //will be more complicated later. this is just for now
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        
        //NEVER FORGET!
        scanner.close();
        System.out.println("User input retrieved");
        return num;
        */
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