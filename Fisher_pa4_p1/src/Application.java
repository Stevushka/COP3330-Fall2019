//import ;
import java.io.*;
import java.util.*;

public class Application //PROGRAMING ASSIGNMENT 4, PROBLEM 1
{
    public static void main (String[] args) throws IOException
    {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        File inputFile = new File("problem1.txt");
        File outputFile = new File("unique_words.txt");
        FileInputStream fileInputStream;         //File input stream
        FileOutputStream fileOutputStream;         //File output stream

        // Try to open file
        System.out.println("Opening file problem1.txt.");
        fileInputStream = new FileInputStream(inputFile); //File output stream

        System.out.println("Opening file unique_words.txt.");
        fileOutputStream = new FileOutputStream(outputFile); //File output stream

        System.out.println("@>-----------------<@");
        duplicateRemover.remove(fileInputStream);
        System.out.println("@>-----------------<@");
        duplicateRemover.write(fileOutputStream);


        // Done with file, so try to close it
        System.out.println("Closing file problem1.txt");
        fileInputStream.close(); //close() may throw IOException if fails

        System.out.println("Closing file unique_words.txt");
        fileOutputStream.close(); //close() may throw IOException if fails
    }
}
