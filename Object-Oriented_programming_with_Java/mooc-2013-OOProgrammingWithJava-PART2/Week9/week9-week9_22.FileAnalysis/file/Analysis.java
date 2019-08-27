package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {
    private File file;

    public Analysis(File file) throws Exception {
        this.file = file;
    }

    public int lines() throws FileNotFoundException {
        Scanner reader = new Scanner(this.file);
        int lineNum = 0;

        while(reader.hasNextLine()) {
            reader.nextLine();
            lineNum++;
        }
        reader.close();

        return lineNum;
    }

    public int characters() throws FileNotFoundException {
        Scanner reader = new Scanner(this.file);
        int counter = this.lines();

        while(reader.hasNextLine()) {
            String s = reader.useDelimiter("").nextLine();
            counter += s.length();
        }

        reader.close();

        return counter;
    }
}