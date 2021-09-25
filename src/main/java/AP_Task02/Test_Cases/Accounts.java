package AP_Task02.Test_Cases;

import java.text.SimpleDateFormat;  
import java.util.Date;

public abstract class Accounts 
{
	private static int account_count = 0;
	protected String account_number;
	protected double balance;
	protected String date_created;
	protected String time_created;
	protected boolean type;
	
	Accounts(double b,boolean t)
	{
		account_number = 1000+Integer.toString(account_count);
		balance = b;
		//Setting date and time creation for the account
			String date = "";
			SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date temp_date = new Date();  
			date = formats.format(temp_date);
			String date_created = "";
			String time_created = "";
			boolean check = false;
			for(int i=0;i<date.length();i++) 
			{
				if(check == false)
					date_created += date.charAt(i);
				else time_created += date.charAt(i);
				if(date.charAt(i) == ' ')
		  		check = true;
			}
			this.date_created = date_created;
			this.time_created = time_created;
		type = t;
		account_count++;
		
	}
}