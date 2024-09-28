package apis.us;


public class UserCommImpl implements UserCommHandler{

    String outPutLocation=null;
    String inputType=null;
    //SEE THE UserCommHandler TO FIND OUT WHAT THESE DO!!!
    
    @Override
    public void getUserInput() {
        //Put a scanner here or something, idk
        //I'm not sure how this even runs
        
        
    }

    @Override
    public void setDelimiters() {
        // Set the Delimiters for the output/input? Call setOutputType?
        
    }

    @Override
    public String setOutputType(String stringParam) {
        // Slap a bunch of switch cases to set the method type
        //File
        //command line
        String upperS=stringParam.toLowerCase();
        
        switch (upperS) {
        case "file":
            System.out.println("default filename");
            outPutLocation="file";
            break;
            
        case "command":
            System.out.println("command.");
            outPutLocation="commnand";
            break;
            
        default:
            System.out.println("output type automatically set to command");
            outPutLocation="file";
            break;
    }
        
        return outPutLocation;
    }

    @Override
    public void outPut(String stringParam) {
        
        //Depending on where this goes, do it
        //file
        //or command line
        System.out.println(stringParam);
    }

    @Override
    public void outPut(int i) {
        outPut(Integer.toString(i));
    }
    
    
}
