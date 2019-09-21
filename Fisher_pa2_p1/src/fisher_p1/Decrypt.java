package fisher_p1;

import java.util.Scanner;

public class Decrypt 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input;
		int output;
		int firstDigit;
		int secondDigit;
		int thirdDigit;
		int fourthDigit;
		int tempDigit;
		
		//Scan for the number to be decrypted
		System.out.println("Enter your number here:");
		input = scan.nextInt();
		
		//Check if the input is a 4-digit number
		while((input < 1000) || (input > 9999))
		{
			System.out.println("Invalid! Must be a 4-digit number!");
			
			System.out.println("Enter your number here:");
			input = scan.nextInt();
		}
		
		//Display encrypted number
		System.out.println("The number to be decrypted: " + input);
		
		//Store each digit individually
		firstDigit = input / 1000;
		secondDigit = (input / 100) % 10;
		thirdDigit = (input / 10) % 10;
		fourthDigit = input % 10;
		
		//Swap the first and third digits around
		tempDigit = firstDigit;
		firstDigit = thirdDigit; 
		thirdDigit = tempDigit;
		
		//swap the second and fourth digits around
		tempDigit = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = tempDigit;
		
		//Reverse and fix the first digit
		if(firstDigit > 6)
		{
			firstDigit -= 7;
		}
		else
		{
			firstDigit += 3;
		}
		
		//Reverse and fix the second digit
		if(secondDigit > 6)
		{
			secondDigit -= 7;
		}
		else
		{
			secondDigit += 3;
		}
		
		//Reverse and fix the third digit
		if(thirdDigit > 6)
		{
			thirdDigit -= 7;
		}
		else
		{
			thirdDigit += 3;
		}
		
		//Reverse and fix the fourth digit
		if(fourthDigit > 6)
		{
			fourthDigit -= 7;
		}
		else
		{
			fourthDigit += 3;
		}
		
		//Form the new 4-digit number
		firstDigit *= 1000;
		secondDigit *= 100;
		thirdDigit *= 10;
		output = firstDigit + secondDigit + thirdDigit + fourthDigit;
		
		//Display decrypted number
		System.out.println("Your decrypted number is: " + output + "");
	}
}