/**
 * Created by Dave on 3/14/17.
 */

import java.io.*;
import java.util.*;

public class TextFiles {

    public static void main(String[] args) {
        String filepath = "/Users/Dave/IdeaProjects/OpenAndEditTextFiles/1984.txt";
        readFile(filepath);
        writeToEndOfFile(filepath, "This should be the last line");
        readFile(filepath);
        System.out.println();
        System.out.println();
        System.out.println();
        writeToFrontOfFile(filepath,"This should be the first line");
        readFile(filepath);
    }

    private static void readFile(String filepath) {
        String line;

        File fileToRead = new File(filepath);
        if (fileToRead.exists()) {
            try {
                // FileReader to read text files in default encoding
                FileReader fileReader = new FileReader(filepath);

                // wrap FileReader in BufferedReader
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
            }
            catch (IOException ex) {
                System.out.println("Unable to open file " + filepath);
            }
        }
        else {
            System.out.println("File does not exist");
        }
    }

    private static void writeToEndOfFile(String filepath, String s) {
        File file = new File(filepath);

        if (file.exists()) {
            try {

                FileWriter fileWriter = new FileWriter(filepath, true); // true means we append to the file
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // write text to the end of the file
                bufferedWriter.append(s);

                bufferedWriter.close();
            }
            catch (IOException ex) {
                System.out.println("Unable to open file " + filepath);
            }
        }
        else
            System.out.println("File does not exist");
    }

    private static void writeToFrontOfFile(String filepath, String s) {
        File file = new File(filepath);
        String line;
        ArrayList<String> copyOfFile = new ArrayList<>();

        if (file.exists()) {
            try {
                // read the file and store it in the ArrayList
                FileReader fileReader = new FileReader(filepath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    copyOfFile.add(line);
                }
                bufferedReader.close();

                // Write new text plus all old text to the file
                FileWriter fileWriter = new FileWriter(filepath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // write user supplied string
                bufferedWriter.write(s);

                // write all the old text after the new text
                for (String text : copyOfFile) {
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (IOException ioe) {
                System.out.println("Error occurred " + ioe.getMessage());
            }
        }
        else
            System.out.println("File does not exist");
    }
}
