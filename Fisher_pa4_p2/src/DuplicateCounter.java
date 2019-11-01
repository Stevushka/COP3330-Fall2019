//import ;
import java.util.*;
import java.io.*;

public class DuplicateCounter //PROGRAMING ASSIGNMENT 4, PROBLEM 2
{
    private ArrayList<String> inputWords = new ArrayList<String>();
    private HashSet<String> uniqueWords = new HashSet<String>();
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

    public DuplicateCounter()
    {
        //default constructor
    }

    public void count(FileInputStream dataFile)
    {
        Scanner inFS = new Scanner(dataFile);

        while (inFS.hasNext()) //if there's another word that can be copied, copy it into inputWords
        {
            String input = inFS.next();
            inputWords.add(input);
            System.out.println("input word: " + input);
        }

        for (String w : inputWords) //cycle through every word in inputWords
            if (!uniqueWords.contains(w)) //copy the word into uniqueWords if its not already there
                uniqueWords.add(w);

        for(String word : uniqueWords) //cycle through every word in uniqueWords and print them to file
        {
            int count = 0;
            for (String inputWord : inputWords)
                if (inputWord.equals(word))
                    count++;
            wordCount.put(word, count);
        }
        inputWords.clear(); //clear inputWords and all stored values
    }

    public void write(FileOutputStream outputFile)
    {
        PrintWriter outFS = new PrintWriter(outputFile);

        for(String word : uniqueWords) //cycle through every word in uniqueWords and print them to file
            outFS.println(word + ": " + wordCount.get(word) + " Occurrences");
        outFS.flush();

        uniqueWords.clear(); //clear uniqueWords and all stored values
    }
}
