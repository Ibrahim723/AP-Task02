package AP_Task02.Test_Cases;

import java.util.ArrayList;

public class Customer 
{
	private static int customer_count = 0;
	private int customer_id;
	private String name;
    private String address;
   	private String number;
	private boolean savings;
	private boolean checking;
	private Savings savings_account;
	private Checking checking_account;
	
	Customer(String n,String a,String num)
	{
		customer_id = customer_count;
		name = n;
		address = a;
		number = num;
		savings = false;
		checking = false;
		savings_account = null;
		checking_account  = null;
		customer_count++;
	}
	//Getters
	String getName() 
	{
		return this.name;
	}
	String getAddress() 
	{
		return this.address;
	}
	String getNumber() 
	{
		return this.number;
	}
	boolean getSavings() 
	{
		return this.savings;
	}
	boolean getChecking() 
	{
		return this.checking;
	}
	Savings getSavingAccount() 
	{
		return this.savings_account;
	}
	Checking getCheckingAccount() 
	{
		return this.checking_account;
	}
	//Setters
	void setName(String n)
	{
		if(n == null)
			throw new IllegalArgumentException("Name cannot be null...");
		name = n;
	}
	void setAddress(String a)
	{
		if(a == null)
			throw new IllegalArgumentException("Address cannot be null...");
		address = a;
	}
	void setNumber(String num)
	{
		if(num == null)
			throw new IllegalArgumentException("Number cannot be null...");
		number = num;
	}
	void setSavings(boolean s)
	{		
		savings = s;
	}
	void setChecking(boolean c)
	{
		checking = c;
	}
	void setSavingsAccount(Savings s)
	{
		savings_account = s;
	}
	void setCheckingAccount(Checking c)
	{
		checking_account = c;
	}
}
