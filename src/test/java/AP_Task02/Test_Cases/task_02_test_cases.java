package AP_Task02.Test_Cases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class task_02_test_cases 
{

	Customer cust;
	Savings saving_account;
	Checking checking_account;
	double balance;
	double i;
	Customer cust2;
	@Before
	public void setup() 
	{
		String name ="Ibrahim";
		String number = "03037777123";
		String address ="ABC";
		cust = new Customer(name,address,number);
		
		balance = 5000;
		i = 15;
		saving_account = new Savings(balance,true);
		cust.setSavingsAccount(saving_account);
		cust.setChecking(true);
		checking_account = new Checking(balance,true);
		cust.setCheckingAccount(checking_account);
		cust.setChecking(true);
		name = "Muhammad Faisal Sher";
		number = "03036697321";
		address = "House no. 345, G-9 Markaz, Islamabad";
		cust2 = new Customer(name,address,number);
	}
	//---------- TEST CASES FOR CUSTOMER----------
	//Test Cases for setName
	@Test(expected = IllegalArgumentException.class)
	public void nullNameTest() 
	{
		cust.setName(null);
	}
	@Test
	public void nameTest() 
	{
		cust.setName("Faisal");
	}
	//Test Cases for setNumber
	@Test(expected = IllegalArgumentException.class)
	public void nullNumberTest() 
	{
		cust.setNumber(null);
	}
	@Test
	public void numberTest() 
	{
		cust.setNumber("03037777123");
	}
	//Test Cases for setAddress
	@Test(expected = IllegalArgumentException.class)
	public void nullAddressTest() 
	{
		cust.setAddress(null);
	}
	@Test
	public void AddressTest() 
	{
		cust.setName("House number 15-C,Millat Road,Gulistan Colony,Lahore");
	}
	//---------- TEST CASES FOR SAVINGS----------
	//Test Cases for setInterestRate
	@Test(expected = IllegalArgumentException.class)
	public void invalidInterestRate()
	{
		i = -10;
		Savings.setInterestRate(i);
	}
	@Test
	public void InterestRate() 
	{
		Savings.setInterestRate(i);
	}
	//Test Cases for makeDeposit(Savings Account)
	@Test(expected = IllegalArgumentException.class)
	public void invalidSavingsMakeDeposit()
	{
		//Depositing 1000
		cust.getSavingAccount().makeDeposit(-5);
	}
	@Test
	public void savingsMakeDeposit()
	{
		//Depositing 1000
		double new_balance = cust.getSavingAccount().getBalance() + 1000;
		cust.getSavingAccount().makeDeposit(1000);
		assertTrue(new_balance == cust.getSavingAccount().getBalance());
	}
	
	//Test Cases for makeWithdrawl(Savings Account)
	@Test(expected = IllegalArgumentException.class)
	public void invalidSavingsMakeWithdrawl()
	{
		cust.getSavingAccount().setBalance(1000);
		//Withdrawing 2000
		cust.getSavingAccount().makeWithdrawal(2000);
	}
	@Test
	public void SavingsMakeWithdrawl()
	{
		cust.getSavingAccount().setBalance(10000);
		//Withdrawing 500
		cust.getSavingAccount().makeWithdrawal(500);
		double new_balance = cust.getSavingAccount().getBalance();
		assertTrue(new_balance == cust.getSavingAccount().getBalance());
	}
	//Test Cases for calculating interest
	@Test
	public void SavingsCalculateInterest()
	{
		cust.getSavingAccount().setBalance(1000);
		i = 10;
		Savings.setInterestRate(i);
		assertTrue(cust.getSavingAccount().calculateInterest() == 100);
	}
	//Test Cases for calculating zakat
	@Test(expected = IllegalArgumentException.class)
	public void invalidSavingsCalculateZakat()
	{
		cust.getSavingAccount().setBalance(15760);
		cust.getSavingAccount().calculateZakat();
	}	
	@Test
	public void SavingsCalculateZakat()
	{
		cust.getSavingAccount().setBalance(25000);
		assertTrue(cust.getSavingAccount().calculateZakat() == 625);
	}
	//---------- TEST CASES FOR CHECKING----------
	//Test Cases for makeDeposit(Savings Account)
	@Test(expected = IllegalArgumentException.class)
	public void invalidCheckingMakeDeposit()
	{
		//Depositing 1000
		cust.getCheckingAccount().makeDeposit(-5);
	}
	@Test
	public void checkingsMakeDeposit()
	{
		//Depositing 1000
		double new_balance = cust.getCheckingAccount().getBalance() + 1000;
		cust.getCheckingAccount().makeDeposit(1000);
		assertTrue(new_balance == cust.getCheckingAccount().getBalance());
	}
	//Test Cases for makeWithdrawl(Savings Account)
	@Test(expected = IllegalArgumentException.class)
	public void invalidCheckingMakeWithdrawl()
	{
		cust.getCheckingAccount().setBalance(1000);
		//Withdrawing 2000
		cust.getCheckingAccount().makeWithdrawal(2000);
	}
	@Test(expected = IllegalArgumentException.class)
	public void negativeCheckingMakeWithdrawl()
	{
		cust.getCheckingAccount().setBalance(1000);
		cust.getCheckingAccount().makeWithdrawal(-500);
	}
	@Test
	public void CheckingMakeWithdrawl()
	{
		cust.getSavingAccount().setBalance(10000);
		//Withdrawing 500
		cust.getSavingAccount().makeWithdrawal(500);
		double new_balance = cust.getCheckingAccount().getBalance();
		assertTrue(new_balance == cust.getCheckingAccount().getBalance());
	}
	@Test
	public void CheckingCheckTransactionFeeTrue()
	{
		cust2.setCheckingAccount(checking_account);
		cust2.getCheckingAccount().setBalance(15000);
		cust2.getCheckingAccount().makeDeposit(1000);
		cust2.getCheckingAccount().makeDeposit(1000);
		cust2.getCheckingAccount().makeDeposit(1000);
		assertTrue(cust2.getCheckingAccount().checkTransactionFee()== true);
	}
	@Test
	public void checkingCheckTransactionFeeFalse()
	{
		cust2.setCheckingAccount(checking_account);
		cust2.getCheckingAccount().setBalance(15000);
		cust2.getCheckingAccount().makeDeposit(1000);
		assertTrue(cust2.getCheckingAccount().checkTransactionFee()== false);
	}
	
}
