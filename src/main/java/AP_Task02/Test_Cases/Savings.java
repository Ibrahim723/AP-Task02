package AP_Task02.Test_Cases;


public class Savings extends Accounts
{
	static double interest_rate = 0.10;
	
	static void setInterestRate(double i)
	{
		if(i<0 || i>100)
			throw new IllegalArgumentException("Interest rate must be between 0-100");
		interest_rate = i;
	}
	
	Savings(double b, boolean t) 
	{
		super(b, t);
	}	
	double getBalance()
	{
		return this.balance;
	}
	
	void setBalance(double b)
	{
		this.balance = b;
	}
	void makeDeposit(double d)
	{
		if(d<0)
		{
			throw new IllegalArgumentException("Deposit amount cannot be negative...");
		}
		this.setBalance(this.getBalance()+d);
	}
	void makeWithdrawal(double w)
	{
		if(w<0)
			throw new IllegalArgumentException("Withdraw amount cannot be negative...");
		else if(w > this.getBalance())
			throw new IllegalArgumentException("Withdraw amount cannot be greater than current balance...");
			
		this.setBalance(this.getBalance()-w);
	}
	double calculateInterest()
	{
		double interest;
		interest = this.getBalance() * interest_rate;
		interest /= 100;
		return interest;
	}
	double calculateZakat()
	{
		
		if(this.getBalance() >= 20000)
		{
			double zakat;
			zakat = (this.getBalance()*2.5)/100;
			return zakat;
		}
		else
		{
			throw new IllegalArgumentException("Your balance is less than 20,000...");
		}
	}
}