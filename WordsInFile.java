
/**
 * Write a description of WordsInFile here.
 * Exercise code from the Java Course - Duke @ Coursera
 * @author (Dool) 
 * @version (0)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class WordsInFile {
    
    private HashMap<String, ArrayList<String>> map;
    
    public WordsInFile(){
        map = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String name = f.getName();
        for (String word: fr.words()){
            if (!map.containsKey(word)){
                map.put(word, new ArrayList<String>());
                map.get(word).add(name);
            } else if (map.containsKey(word) && !map.get(word).contains(name)){
                    map.get(word).add(name);
                }
            }
        }
        
        
         public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    
    public int maxNumber(){
        int maxNumFiles = 0;
        for (String words: map.keySet()){
            int curr = map.get(words).size();
            if ( curr > maxNumFiles){
                maxNumFiles = curr;
            }
        }
        return maxNumFiles;
    }
    
    
    public ArrayList<String> wordsInNumFiles(int num){
        ArrayList<String> wordFile = new ArrayList<String>();
        for (String word: map.keySet()){
            if (map.get(word).size() == num){
                wordFile.add(word);
            }
        }
        
        return wordFile;
    }
    
    public void printFilesIn(String word){
        for (String s: map.keySet()){
            if (s.equals(word)){
                for (int i = 0; i < map.get(s).size(); i++){
                    System.out.println(map.get(s).get(i));
                }
            }
        }
        
    }
    
    public void testPrinting(){
    }
    
    public void tester(){
        buildWordFileMap();
        System.out.println("The maximum number of files any word appears is: " + maxNumber());
        ArrayList<String> numWords = wordsInNumFiles(4);
        System.out.println("The number of words are: " + numWords.size());
        for (int i = 0; i< numWords.size(); i++){
            System.out.println(numWords.get(i));
        }
        
        printFilesIn("tree");
    }
    }
    
   

