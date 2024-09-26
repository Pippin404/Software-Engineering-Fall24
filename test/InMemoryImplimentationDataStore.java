import java.util.ArrayList;

import apis.DataBaseHandler;

public class InMemoryImplimentationDataStore implements DataBaseHandler{  

    ArrayList<Integer> results = new ArrayList<Integer>();
    
    
    @Override
    public String storeData(int i) {
        //results of computation
        System.out.println("I stored the int in the local arraylist");
        results.add(i,0);
        String s="FileName";
        return s;
    }
    
    
    @Override
    public int sendData(String s) {       
        
        //gets the int in the filename
        if(s=="FileName") {
            System.out.println("Retrived File");
            return 1; //return 1 FOR NOW, otherwise results.get(0);
        }else {
            System.out.println("Failure to Fetch File");
            return -1;
        }
    }  
    
    
    
    

