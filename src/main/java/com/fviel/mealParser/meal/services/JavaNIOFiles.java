package com.fviel.mealParser.meal.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
 * This class reads the file using a simpler aproach
 * wich Files
 */
@Service("javaNIOFiles")
@Slf4j
public class JavaNIOFiles implements ContentReader {
    
    @Override    
    public String readContentFromFileAsString(String filePath){

        try {
            // Read the file content as a String
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));             
            return jsonContent;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }   

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