//import ;
import java.util.*;
import java.io.*;

public class DuplicateRemover //PROGRAMING ASSIGNMENT 4, PROBLEM 1
{
    private ArrayList<String> inputWords = new ArrayList<String>();
    private HashSet<String> uniqueWords = new HashSet<String>();

    public DuplicateRemover()
    {
        //default constructor
    }

    public void remove(FileInputStream dataFile)
    {
        Scanner inFS = new Scanner(dataFile);

        while (inFS.hasNext()) //if there's another word that can be copied, copy it into inputWords
        {
            String input = inFS.next(); //record the next word
            inputWords.add(input); //add the new word to inputWords
            System.out.println("input word: " + input);
        }

        for (int i = 0; i < inputWords.size() - 1; i++) //cycle through every word in inputWords
        {
            if (!uniqueWords.contains(inputWords.get(i))) //copy the word into uniqueWords if its not already there
                uniqueWords.add(inputWords.get(i));
        }

        inputWords.clear(); //clear inputWords and all stored values
    }

    public void write(FileOutputStream outputFile)
    {
        PrintWriter outFS = new PrintWriter(outputFile);

        //Collections.sort(uniqueWords); //sort the words in uniqueWords alphabetically //<- ONLY WORKS AS AN ARRAYLIST

        //for (int i = 0; i < uniqueWords.size(); i++) //cycle through every word in uniqueWords and print them to file
        //    outFS.println(uniqueWords.get(i));

        for(String word : uniqueWords) //cycle through every word in uniqueWords and print them to file
            outFS.println(word);
        outFS.flush(); //force output to be written to file

        uniqueWords.clear(); //clear uniqueWords and all stored values
    }
}
