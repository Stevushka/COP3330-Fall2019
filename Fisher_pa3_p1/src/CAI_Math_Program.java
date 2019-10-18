import java.util.*;
import java.security.SecureRandom;

public class CAI_Math_Program
{
    public static int newQuestion(int problemType, int num1, int num2, int i, int randType)
    {
        int correctAns;
        switch(problemType)
        {
            case 1:
                correctAns = additionProblem(num1, num2, i);
                break;
            case 2:
                correctAns = multiplicationProblem(num1, num2, i);
                break;
            case 3:
                correctAns = subtractionProblem(num1, num2, i);
                break;
            case 4:
                correctAns = divisionProblem(num1, num2, i);
                break;
            case 5:
                correctAns = randomProblem(num1, num2, i, randType);
                break;
            default:
                System.out.println("Ya done goofed 1");
                correctAns = 42;
                break;
        }

        return correctAns;
    }

    public static int additionProblem(int num1, int num2, int i)
    {
        int correctAns;
        System.out.println("Q" + i + ": How Much is " + num1 + " plus " + num2 + "?");
        correctAns = num1 + num2;

        return correctAns;
    }

    public static int multiplicationProblem(int num1, int num2, int i)
    {
        int correctAns;
        System.out.println("Q" + i + ": How Much is " + num1 + " times " + num2 + "?");
        correctAns = num1 * num2;

        return correctAns;
    }

    public static int subtractionProblem(int num1, int num2, int i)
    {
        int correctAns;
        System.out.println("Q" + i + ": How Much is " + num1 + " minus " + num2 + "?");
        correctAns = num1 - num2;

        return correctAns;
    }

    public static int divisionProblem(int num1, int num2, int i)
    {
        int correctAns;
        System.out.println("Q" + i + ": How Much is " + num1 + " divided by " + num2 + "?");
        correctAns = num1 / num2;

        return correctAns;
    }

    public static int randomProblem(int num1, int num2, int i, int randType)
    {
        int correctAns;
        switch(randType)
        {
            case 1:
                correctAns = additionProblem(num1, num2, i);
                break;
            case 2:
                correctAns = multiplicationProblem(num1, num2, i);
                break;
            case 3:
                correctAns = subtractionProblem(num1, num2, i);
                break;
            case 4:
                correctAns = divisionProblem(num1, num2, i);
                break;
            default:
                System.out.println("Ya done goofed 2");
                correctAns = 42;
                break;
        }

        return correctAns;
    }

    public static void main(String[] args)
    {
        int num1 = 0, num2, lastNum;
        int userAns, correctAns;
        int finished = -1;
        int response, problemType, difficulty, bound, randType;
        String keepGoing;
        double numCorrect, percentCorrect;
        //String[] rightResponses = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work"};
        //String[] wrongResponses = {"No. Please try again.", "Wrong. Try once more.", "Don’t give up!", "No. Keep trying."};
        SecureRandom random = new SecureRandom();
        Scanner scan = new Scanner(System.in);
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);



        while(finished == -1)
        {
            numCorrect = 0.00;

            //ask for problem type
            System.out.println("What kind of problem do you want to solve?" +
                    "\n1 -Addition \n2 -Multiplication \n3 -Subtraction \n4 -Division \n5 -Random Mix");
            problemType = scan.nextInt();
            while(problemType < 1 || problemType > 5)
            {
                System.out.println("Invalid response, please enter a number from 1 to 5");
                problemType = scan.nextInt();
            }

            //ask for problem difficulty, and ask again if the user enters an invalid number
            System.out.println("How difficult do you want the problems to be? (1, 2, 3, or 4 digit numbers?)");
            difficulty = scan.nextInt();
            while(difficulty < 1 || difficulty > 4)
            {
                System.out.println("Invalid response, please enter a number from 1 to 4");
                difficulty = scan.nextInt();
            }

            //Set the bound for the RNGs, aka the difficulty of each problem in this set
            bound = 1;
            for(int j = 0; j < difficulty; j++)
                bound *= 10;

            //Let the games begin!... Uh, I mean, ask the student 10 questions
            for(int i = 1; i < 11; i++)
            {
                lastNum = num1;

                //I've modified the RNGs to use the bound set earlier from the user's inputted difficulty
                while(num1 == lastNum) //ensures that the second number is different than the last question
                    num1 = random.nextInt((bound)-(bound / 10)) + (bound / 10); //Generates numbers from a range according to the problem difficulty
                num2 = random.nextInt((bound)-(bound / 10)) + (bound / 10); //Generates numbers from a range according to the problem difficulty
                while(num2 == 0 && problemType == 4) //ensures that thw second number isn't 0 if the problem type is division, since that would cause an error
                    num2 = random.nextInt((bound)-(bound / 10)) + (bound / 10);

                randType = random.nextInt(4) + 1; //Generates a random question type,
                    // in case the user wants a variety of different question types

                //Ask the question and scan for the student's answer
                correctAns = newQuestion(problemType, num1, num2, i, randType);
                userAns = scan.nextInt();

                //Generate the response and see if the student is correct or not
                response = random.nextInt(4) + 1; //Generates numbers 1 - 4
                if (userAns == correctAns)
                {
                    numCorrect++;
                    switch(response)//I just want to mention that I don't agree with using a switch for this,
                    // I'd rather use an array and call from a random index of an array of responses.
                    {
                        case 1:
                            System.out.println("Very good!");
                            break;
                        case 2:
                            System.out.println("Excellent!");
                            break;
                        case 3:
                            System.out.println("Nice work!");
                            break;
                        default:
                            System.out.println("Keep up the good work");
                            break;
                    }
                    //System.out.println(rightResponses[response]); //This is MUCH more efficient than a switch statement...
                }
                else
                {
                    //We don't need to calculate the number of incorrect, if we have the number of correct and the total number of problems given.
                    switch(response) //I just want to mention that I don't agree with using a switch for this,
                    // I'd rather use an array and call from a random index of an array of responses.
                    {
                        case 1:
                            System.out.println("No. Please try again.");
                            break;
                        case 2:
                            System.out.println("Wrong. Try once more.");
                            break;
                        case 3:
                            System.out.println("Don’t give up!");
                            break;
                        default:
                            System.out.println("No. Keep trying.");
                            break;
                    }
                    //System.out.println(wrongResponses[response]); //This is MUCH more efficient than a switch statement...
                }
            }

            //Calculate percent correct and display results
            percentCorrect = (numCorrect / 10) * 100;
            System.out.print("Percent correct: " + percentCorrect + "% ||| ");
            if(percentCorrect >= 75.0) //if above 75%, the student can move on, if not, they need more help
            {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else
            {
                System.out.println("Please ask your teacher for extra help.");
            }

            //Ask the user to exit or continue the program after each student
            System.out.println("Reset for the next student? (yes / no)");
            keepGoing = scan.next();
            if(keepGoing.equals("no"))
            {
                finished = 1;
            }
        }
    }
}
