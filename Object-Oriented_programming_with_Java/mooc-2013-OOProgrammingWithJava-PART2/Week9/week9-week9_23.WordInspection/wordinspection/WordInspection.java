package wordinspection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;

    public WordInspection(File file) throws Exception, FileNotFoundException {
        this.file = file;
    }

    public int wordCount() throws FileNotFoundException {
        Scanner reader = new Scanner(this.file, "UTF-8");
        int wordNum = 0;
        while(reader.hasNextLine()) {
            reader.nextLine();
            wordNum++;
        }

        return wordNum;
    }

    public List<String> wordsContainingZ() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();

        Scanner reader = new Scanner(this.file, "UTF-8");
        while(reader.hasNextLine()) {
            String s = reader.nextLine();
            if(s.contains("z")) {
                list.add(s);
            }
        }

        return list;
    }

    public List<String> wordsEndingInL() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();

        Scanner reader = new Scanner(this.file, "UTF-8");
        while(reader.hasNextLine()) {
            String s = reader.nextLine();
            String[] word = s.split("");
            if(word[word.length - 1].equals("l")) {
                list.add(s);
            }
        }

        return list;
    }

    public List<String> palindromes() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();

        Scanner reader = new Scanner(this.file, "UTF-8");
        while(reader.hasNextLine()) {
            String s = reader.nextLine();
            String rev = "";
            for(int i = s.length() - 1; i >= 0; i--) {
                rev = rev + s.charAt(i);
            }

            if(rev.equals(s)) {
                list.add(s);
            }
        }

        return list;
    }

    public List<String> wordsWhichContainAllVowels() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();

        Scanner reader = new Scanner(this.file, "UTF-8");
        while(reader.hasNextLine()) {
            String s = reader.nextLine();

            if(s.contains("a") && s.contains("e") &&
                    s.contains("i") && s.contains("o") && s.contains("u")  &&
                    s.contains("y") && s.contains("ä") && s.contains("ö")) {
                list.add(s);
            }
        }

        return list;
    }
}