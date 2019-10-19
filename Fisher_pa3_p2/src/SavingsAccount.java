//import

public class SavingsAccount
{
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double balance)
    {
        savingsBalance = balance;
    }

    public static void modifyInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }

    public double calculateMonthlyInterest()
    {
        double monthlyInterest;
        monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;

        return savingsBalance;
    }
}
