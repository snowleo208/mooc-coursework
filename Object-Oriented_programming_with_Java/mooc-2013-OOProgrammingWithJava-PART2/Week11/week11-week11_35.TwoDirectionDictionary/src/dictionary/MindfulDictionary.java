/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author snowleo208
 */
public class MindfulDictionary {
    private Map<String, String> dict;
    private String file;
    private Scanner fileReader;
    
    public MindfulDictionary() {
        this.dict = new HashMap<String,String>();
    }
    
    public MindfulDictionary(String file) throws FileNotFoundException {
        this();
        this.file = file;
    }
    
    public boolean load() {
        try {
            File newFile = new File(this.file);
            this.fileReader = new Scanner(newFile);
            while ( this.fileReader.hasNextLine() ){
                String line = this.fileReader.nextLine();
                String[] parts = line.split(":"); 
                this.dict.put(parts[0], parts[1]);
            }

            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try {
            File newFile = new File(this.file);
            FileWriter writer = new FileWriter(newFile);
            for (String k : this.dict.keySet()) {
                String word = k + ":" + this.dict.get(k) + "\n";
                writer.write(word);
            }
            writer.close();

            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public void add(String word, String translation) {
        if(this.dict.containsKey(word)) {
            return;
        }
        
        this.dict.put(word, translation);
    }
    
    public String translate(String word) {
        if(!this.dict.containsKey(word) && !this.dict.containsValue(word)) {
            return null;
        }
        
        for (String w : this.dict.keySet()) {
            // if key equals word, returns value
            if(w.equals(word)) {
                return this.dict.get(w);
            }
            
            // if value equals word, returns key
            if(this.dict.get(w).equals(word)) {
                return w;
            }
        }
        
        return null;
    }
    
    public void remove(String word) {
        // if key equals word, remove key
        if(this.dict.containsKey(word)) {
            this.dict.remove(word);
        }
        
        // if value equals word, delete key
        if (this.translate(word) != null) {
            this.dict.remove(this.translate(word));
        }
        
    }
}
