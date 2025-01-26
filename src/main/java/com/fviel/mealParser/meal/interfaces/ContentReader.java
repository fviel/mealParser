package com.fviel.mealParser.meal.interfaces;

import java.util.List;

import com.fviel.mealParser.meal.annotations.LogExecutionTime;
import com.fviel.mealParser.meal.dtos.MealDto;

public interface ContentReader {

    
    public String readContentFromFileAsString(String filePath); 

    public List<MealDto> getMeals(String mealsString);

    public void printMealsFromString(String meals);

    public void printMealsFromObject( List<MealDto> meals);
}
