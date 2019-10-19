//import

public class SavingsAccountTest
{
    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        System.out.println("Balance after 12 months with initial interest rate");
        saver1.modifyInterestRate(0.04);
        for(int i = 0; i < 11; i++) //run the method 11 times
            saver1.calculateMonthlyInterest();
        System.out.println(saver1.calculateMonthlyInterest()); //run a 12th time, and display the total

        for(int i = 0; i < 11; i++) //run the method 11 times,
            saver2.calculateMonthlyInterest();
        System.out.println(saver2.calculateMonthlyInterest()); //run a 12th time, and display the total

        System.out.println(" "); //Provide space between the outputs

        System.out.println("Balance on the 13th month, after interest rate increase: ");
        saver2.modifyInterestRate(0.05);
        System.out.println(saver1.calculateMonthlyInterest());
        System.out.println(saver2.calculateMonthlyInterest());
    }
}
