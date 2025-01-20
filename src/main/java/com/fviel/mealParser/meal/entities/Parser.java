import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import netscape.javascript.JSObject;

public class Parser{

    private static final String FILE_PATH = "./data.txt";

    public static String readFile(String path){
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
    }

    public static void parseContent(String content){
        List<EntryDto> response = new ArrayList<>();    
        String[] entries = content.split("{");
        System.out.println("parseContent len: " + entries.length);






        //return response;
    }    

    public static void main(String... args){
        String fileContent = readFile(FILE_PATH);
        parseContent(fileContent);

   }
}