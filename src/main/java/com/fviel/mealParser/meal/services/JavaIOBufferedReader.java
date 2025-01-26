package com.fviel.mealParser.meal.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fviel.mealParser.meal.dtos.MealDto;
import com.fviel.mealParser.meal.interfaces.ContentReader;
import lombok.extern.slf4j.Slf4j;


/**
 * This class was how I solved the code Challenge.
 * The problem is I used an old aproach to read the file, from Java IO
 * A better option was to use a newer libbraries from java.nio, like Files.
 */
@Service("javaIOBufferedReader")
@Slf4j
public class JavaIOBufferedReader implements ContentReader{
    
    @Override
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

    //---------------------

    public List<MealDto> getMeals(String mealsString){
        try{
         // Parse the JSON string into a list of User objects
         ObjectMapper objectMapper = new ObjectMapper();
         List<MealDto> meals = objectMapper.readValue(mealsString, new TypeReference<List<MealDto>>() {});
         return meals;
        }catch( JsonMappingException jme){
            jme.printStackTrace();
            return null;
        }catch(JsonProcessingException jpe){
            jpe.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void printMealsFromString(String meals){
        System.out.println(meals);
    }

    public void printMealsFromObject( List<MealDto> meals){
        // Print the users
        for (MealDto meal : meals) {
            System.out.println(meal);
        }
    }
}
