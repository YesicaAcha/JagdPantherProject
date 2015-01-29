package framework.utils;

import java.io.*;
import java.util.HashMap;

public class ReadTextFile {

    private String fileLocation;

    public ReadTextFile(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public HashMap<String,String[]> getData(){
        HashMap<String,String[]> keyValuePair=new HashMap<String,String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
            String stringLine;
            
            //Read File Line By Line
            while ((stringLine = br.readLine()) != null)   {
               
            	String[] keyValue=stringLine.split("=");
                keyValuePair.put(keyValue[0],keyValue[1].split(","));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return keyValuePair;
    }


}
