package smoketests;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import apis.us.OutputType;
import apis.us.UserCommunicatorImpl;


public class SmokeTestUS {

    
    @Test
    public void outputAssignmentTest() {
        //UserCommunicatorImpl com=new UserCommunicatorImpl();
        
        //do this 3 times to make sure the lower case function is working
       OutputType out=OutputType.TEXT;
       System.out.println(out);
       OutputType out2=OutputType.CONSOLE;
       System.out.println(out2);
       OutputType out3=OutputType.CSV;
       System.out.println(out3);
       OutputType out4=OutputType.JSON;
       System.out.println(out4);
        
    }
    
    
    @Test
    public void userInput() {
        
        UserCommunicatorImpl com=new UserCommunicatorImpl();
        com.getUserInput();
        
        //this should scan something. will ask about it in class
        
        
    }
    
    
    //no other tests to assert return items
    
    
    
}
