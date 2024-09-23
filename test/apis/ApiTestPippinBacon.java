package apis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTestPippinBacon {
 
    
    @Test
    public void smokeTest() {
        
        //this is importing an empty implementation
        DataBaseHandler Data = new DataBaseImpl();
        
        String s = Data.storeData(5);
        //store an int 5 in a file named s
        
        
        int I = Data.sendData("Hello");
        //this should return the int in the file called Hello
        
        
        //this should return 3
        Assertions.assertEquals(I, 3);
        Assertions.assertEquals(s,"ExampleFileName");
        
    }
    
    
    
    

}