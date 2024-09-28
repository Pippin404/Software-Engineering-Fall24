package smoketests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import apis.us.UserCommImpl;


public class SmokeTestUS {

    
    @Test
    public void outputTest() {
        UserCommImpl com=new UserCommImpl();
        
        //do this 3 times to make sure the lower case function is working
        
        String res=com.setOutputType("FILE");
        //checks if equal. if not, throw!
        Assertions.assertEquals(res,"file");

        res=com.setOutputType("File");
        //checks if equal. if not, throw!
        Assertions.assertEquals(res,"file");
        
        res=com.setOutputType("file");
        //checks if equal. if not, throw!
        Assertions.assertEquals(res,"file");
        
    }
    
    
    @Test
    public void userInput() {
        
        UserCommImpl com=new UserCommImpl();
        com.getUserInput();
        
        //this should scan something. will ask about it in class
        
        
    }
    
    
    //no other tests to assert return items
    
    
    
}
