//import ;
import java.io.*;
import java.util.*;

public class Application //PROGRAMING ASSIGNMENT 4, PROBLEM 2
{
    public static void main (String[] args) throws IOException
    {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        File inputFile = new File("problem2.txt");
        File outputFile = new File("unique_word_counts.txt");
        FileInputStream fileInputStream;         //File input stream
        FileOutputStream fileOutputStream;         //File output stream

        // Try to open file
        System.out.println("Opening file problem1.txt.");
        fileInputStream = new FileInputStream(inputFile); //File output stream

        System.out.println("Opening file unique_words.txt.");
        fileOutputStream = new FileOutputStream(outputFile); //File output stream

        System.out.println("@>-----------------<@");
        duplicateCounter.count(fileInputStream);
        System.out.println("@>-----------------<@");
        duplicateCounter.write(fileOutputStream);


        // Done with file, so try to close it
        System.out.println("Closing file problem1.txt");
        fileInputStream.close(); //close() may throw IOException if fails

        System.out.println("Closing file unique_words.txt");
        fileOutputStream.close(); //close() may throw IOException if fails
    }
}
