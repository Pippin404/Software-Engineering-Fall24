package apis;
public interface DataBaseHandler{


    public String storeData(long l);
    //store long l into something? maybe a file
    //send message to successfully store data

    public long sendData(String s);
    //accepts the location of a file to process



}