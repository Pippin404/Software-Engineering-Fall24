package apis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SmokeTestPippin {

    
    
    
    
    @Test
    public void StoreDatatest() {
        DataBaseImpl D=new DataBaseImpl();
        
        String s=D.storeData(6);
       
            
        //checks if equal. if not, throw!
       Assertions.assertEquals(s,"FileName");
        
        
        
    } 
    
    
    @Test
    public void GetDataTest() {
        
        DataBaseImpl D=new DataBaseImpl();
        D.sendData("FileName");
        Assertions.assertEquals(1,"FileName");
        
    }
    
}
