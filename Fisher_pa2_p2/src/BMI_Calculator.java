import java.util.Scanner;

public class BMI_Calculator 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//Scanner scanS = new Scanner(System.in);
		double weight;
		double height;
		double bmi = 0.0;
		//Metric or Standard
		String mOrS = "";
		
		System.out.println("Metric or Standard? (Type whole word)");
		mOrS = scan.next().toLowerCase();
		
		System.out.println(mOrS);
		
		if(mOrS.equals("metric"))
		{
			System.out.println("What is your weight, in kilograms?");
			weight = scan.nextDouble();
			System.out.println("What is your weight, in centimeters?");
			height = scan.nextDouble();
			
			height /= 100;
			bmi = weight / (Math.pow(height, 2));
		}
		else if(mOrS.equals("standard"))
		{
			System.out.println("What is your weight, in pounds?");
			weight = scan.nextDouble();
			System.out.println("What is your height, in inches?");
			height = scan.nextDouble();
			
			bmi = (703 * weight) / (Math.pow(height, 2));
		}
		else
		{
			System.out.println("Invalid Response!");
		}
		
		System.out.println("Your BMI is: " + bmi);
		
		System.out.println("\nCheck the following chart to see what category your BMI falls under: \n");
		System.out.println("Underweight = <18.5 \nNormal weight = 18.5–24.9 \nOverweight = 25–29.9 \nObesity = BMI of 30 or greater");
		System.out.println("\nHave a great day!");
		
	}
}