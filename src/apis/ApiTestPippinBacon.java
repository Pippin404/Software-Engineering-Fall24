package apis;

public class ApiTestPippinBacon {
    
   private static final DataBaseHandler DataBaseHandler = null;

public static void main(String[] args) {
       
       
       prototype(DataBaseHandler);
       
       
   }
    
   static void prototype(DataBaseHandler dataStore){

       dataStore.sendData("Example Filename");

       dataStore.storeData(7);

   }  
    
}
