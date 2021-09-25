package AP_Task02.Test_Cases;


public class Checking extends Accounts
{
	private int transactions;
	Checking(double b, boolean t) 
	{
		super(b, t);
		transactions = 0;
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
			throw new IllegalArgumentException("Deposit amount cannot be negative...");
		this.setBalance(this.getBalance()+d);
		this.transactions++;
		this.checkTransactionFee();
	}
	void makeWithdrawal(double w)
	{
		if(w<0)
			throw new IllegalArgumentException("Withdraw amount cannot be negative");
		else if(w > this.balance)
			throw new IllegalArgumentException("Withdraw amount cannot be greater than current balance...");
		this.setBalance(this.getBalance()-w);
		this.transactions++;
		this.checkTransactionFee();
	}
	boolean checkTransactionFee()
	{
		if(this.transactions > 2)
		{
			System.out.println("Your monthly transaction limit has exceeded...");
			System.out.println("Transactions done this month: " + this.transactions);
			System.out.println("Transaction fee: 10 Rs" );
			System.out.println("Deducting transaction fee from balance..." );
			this.setBalance(this.getBalance() - 10);
			System.out.println("New balance: " + this.getBalance());
			return true;
		}
		return false;
	}
}