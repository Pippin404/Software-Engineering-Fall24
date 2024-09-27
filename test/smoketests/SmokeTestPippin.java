package smoketests;

import org.junit.jupiter.api.Assertions;

public class SmokeTestPippin {

    
    
    
    
    @Test
    public void storeDatatest() {
        DataBaseImpl d=new DataBaseImpl();
        
        String s=d.storeData(6);
       
            
        //checks if equal. if not, throw!
       Assertions.assertEquals(s,"FileName");
        
        
        
    } 
    
    
    @Test
    public void getDataTest() {
        
        DataBaseImpl d=new DataBaseImpl();
        d.sendData("FileName");
        Assertions.assertEquals(1,"FileName");
        
    }
    
}
