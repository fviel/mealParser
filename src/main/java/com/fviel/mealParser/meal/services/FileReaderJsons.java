package com.fviel.mealParser.meal.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileReaderJsons {
    private final String FILE_PATH = "./data.txt";

    public String readContentFromFileAsString(String path){
        if(path == null ||
         path.isEmpty()){
            return null;
        }

        File inputFile = new File(path);
        if(!inputFile.isFile() ||
        !inputFile.exists()){
            return null;
        }

        BufferedReader bf = null;
        String content = "";
        try{
            bf = new BufferedReader(new FileReader(path));
            if(bf.ready()){
                System.out.println("ready");
                //bf.close();
            }
            

            while(bf.readLine() != null){
                content += bf.readLine();
            }
            //System .out .println(content);
            return content;
        }catch ( FileNotFoundException fnfe){
            System.err.println("Parser.readfile - File not found");
        }catch(Exception e){    
            System.err.println("Parser.readfile - Exception");
        }finally{
            try{                
                if(bf != null ){
                    //closes de file            
                    bf.close();
                }
            }catch(IOException ioe){
                System.err.println("Parser.readfile - Fail when closing the file");
            }
        }
        return null;
    }
}
