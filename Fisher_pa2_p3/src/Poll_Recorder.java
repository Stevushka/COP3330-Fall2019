//Import Packages
import java.util.Scanner;

public class Poll_Recorder 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	//-------------------------------------------------------------------
	//Define
		
		Scanner scan = new Scanner(System.in);
		String[] topics = {"Adventure", "Shooter", "Platformer", "Puzzle", "Visual Novel"};
		//The table row headings
		String[] tableRows = new String[5];
		tableRows[0] = "Adventure   ";
		tableRows[1] = "Shooter     ";
		tableRows[2] = "Platformer  ";
		tableRows[3] = "Puzzle      ";
		tableRows[4] = "Visual Novel";
		int[][] ratings = new int[5][10];
		double[] totals = {0, 0, 0, 0, 0};
		int input = 0;
		int voters = 0;
		String yOrN = "";
		boolean keepGoing = true;
		
		double[] topicAvg = {0.0, 0.0, 0.0, 0.0, 0.0};
		int minVal = 100000000;
		int maxVal = -100000000;
		int minTop = -1;
		int maxTop = -1;
		int i;
		
	//-------------------------------------------------------------------
	//Collect
		
		//main loop collecting ratings from users
		while(keepGoing)
		{
			voters++;
			System.out.println("Hi! Please rate how much each video game genre interests you by giving a rating of 1 to 10 (1 - Not at all, 10 - Very Much)");
			
			for(i = 0; i < topics.length; i++)
			{
				System.out.println("How much do " + topics[i] + " games interest you? (1 - Not at all, 10 - Very Much)");
				input = scan.nextInt(); //scan the user's rating
				totals[i] += input; //add the that topic's total
				ratings[i][input - 1]++; //tally how many people gave that rating
			}
			System.out.println("Thanks for sharing! Your ratings have been recorded.");
			
			//Ask to repeat poll for new user
			System.out.println("New user?");
			yOrN = scan.next().toLowerCase();
			switch(yOrN)
			{
				case "nope":
				case "negative":
				case "n":	
				case "no":
					System.out.println("Thank you for voting! :)\n\n");
					keepGoing = false;
					break;
				default:
					keepGoing = true;
					break;
			}
		}
	
	//-------------------------------------------------------------------
	//Compute
		
		//find highest total
		for(i = 0; i < topics.length; i++)
		{
			if(totals[i] > maxVal)
			{
				maxVal = (int)totals[i];
				maxTop = i;
			}
		}
		
		//find lowest total
		for(i = topics.length - 1; i > -1 ; i--)
		{
			if(totals[i] < minVal)
			{
				minVal = (int)totals[i];
				minTop = i;
			}
		}
		
	//-------------------------------------------------------------------
	//Display
		
		System.out.println("------------------ \nThe Results: \n");
		
		System.out.println("Total voters: " + voters + "\n");
		
		//                 "Adventure    "
		System.out.println("Topics       |  1  2  3  4  5  6  7  8  9 10 | AVG");
		System.out.println("-------------+-------------------------------+-------");
		for(i = 0; i < topics.length; i++)
		{
			topicAvg[i] = totals[i]/voters;
			//Show genre
			System.out.print(tableRows[i] + " | ");
			//Show ratings
			System.out.print(" " + ratings[i][0] + "  " + ratings[i][1] + "  " + ratings[i][2] + "  " + ratings[i][3] + "  " + ratings[i][4] + "  " + ratings[i][5] + "  " + ratings[i][6] + "  " + ratings[i][7] + "  " + ratings[i][8] + "  " + ratings[i][9]); 
			//Show averages
			System.out.println(" | " + topicAvg[i]);
			System.out.println("-------------+-------------------------------+--------");
		}
		
		System.out.println("");
		System.out.println("Highest Rated Genre: " + topics[maxTop]);
		System.out.println("Total ratings: " + maxVal + "\n");
		System.out.println("Lowest Rated Genre: " + topics[minTop]);
		System.out.println("Total ratings: " + minVal + "\n");
		
		
		//A tabular report with the five topics down the left side and the 10 ratings across the top, listing in each column the number of ratings received for each topic
		//To the right of each row, show the average of the ratings for that issue.
		//Which issue received the highest point total? Display both the issue and the point total.
		//Which issue received the lowest point total? Display both the issue and the point total.
		
		//arr[R][C]
		//arr[5][10]
		//arr[topics][?]
	}
}
