package com.giahuy.webapp.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class httpUtils {

    private String value;

    public httpUtils(String value){

        //this.value = value.replace(" ", "");
        this.value = value;
    }

    //chuyen string map vao model
    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static httpUtils of (BufferedReader reader){
        StringBuilder json = new StringBuilder();
        try{
            String line;
            while((line = reader.readLine()) != null){
                json.append(line);
            }
        }catch(IOException e){
           System.out.print(e.getMessage());
        }
        return new httpUtils(json.toString());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
