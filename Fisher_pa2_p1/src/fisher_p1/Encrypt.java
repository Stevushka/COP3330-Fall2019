package fisher_p1;

import java.util.Scanner;

public class Encrypt 
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
		
		//Scan for the number to be encrypted
		System.out.println("Enter your number here:");
		input = scan.nextInt();
		
		//Check if the input is a 4-digit number
		while((input < 1000) || (input > 9999))
		{
			System.out.println("Invalid! Must be a 4-digit number!");
			
			System.out.println("Enter your number here:");
			input = scan.nextInt();
		}
		
		//Display original number
		System.out.println("The number to be encrypted: " + input);
		
		//Store each digit individually
		firstDigit = input / 1000;
		secondDigit = (input / 100) % 10;
		thirdDigit = (input / 10) % 10;
		fourthDigit = input % 10;
		
		//Add seven to each digit
		firstDigit += 7;
		secondDigit += 7;
		thirdDigit += 7;
		fourthDigit += 7;
		
		//Store the remainder from dividing by 10
		firstDigit = firstDigit % 10;
		secondDigit = secondDigit % 10;
		thirdDigit = thirdDigit % 10;
		fourthDigit = fourthDigit % 10;
		
		//Swap the first and third digits around
		tempDigit = firstDigit;
		firstDigit = thirdDigit; 
		thirdDigit = tempDigit;
		
		//swap the second and fourth digits around
		tempDigit = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = tempDigit;
		
		//Form the new 4-digit number
		firstDigit *= 1000;
		secondDigit *= 100;
		thirdDigit *= 10;
		output = firstDigit + secondDigit + thirdDigit + fourthDigit;
		
		//Display the new number
		System.out.println("Your encrypted number is: " + output);
	}
}