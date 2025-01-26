package com.fviel.mealParser.meal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.mealParser.meal.annotations.LogExecutionTime;
import com.fviel.mealParser.meal.interfaces.ContentReader;
import com.fviel.mealParser.meal.services.FileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/meal")
@Slf4j
public class FileProcessorController {

    private final FileService fileService;
    private final ContentReader javaIOReader;
    private final ContentReader javaNIOReader;
    
    @Autowired
    public FileProcessorController(
        @Qualifier("javaIOBufferedReader") ContentReader javaIOReader,
        @Qualifier("javaNIOFiles") ContentReader javaNIOReader,
        FileService fileService) {
        
        this.javaIOReader = javaIOReader;
        this.javaNIOReader = javaNIOReader;
        this.fileService = fileService;
    }
    
   
    @LogExecutionTime
    @PostMapping("/javaio")
    public ResponseEntity<String> readUsingJavaIo(){          
        String meals = javaIOReader.readContentFromFileAsString(getFilePath());
        return ResponseEntity.ok(meals);
    }

    @LogExecutionTime
    @PostMapping("/javanio")
    public ResponseEntity<String> readUsingJavaNioFiles(){       
        String meals = javaNIOReader.readContentFromFileAsString(getFilePath());
        return ResponseEntity.ok(meals);
    }
    
    @LogExecutionTime
    private String getFilePath(){
        try{
            return fileService.getFilePathAsStringByMakingAnTempCopy();
        }catch(Exception ioe){
            ioe.printStackTrace();
            return null;
        }
    }     
}