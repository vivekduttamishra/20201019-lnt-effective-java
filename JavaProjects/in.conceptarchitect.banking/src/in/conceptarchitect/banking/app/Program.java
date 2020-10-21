package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.BankAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount a1=new BankAccount();
		
		a1.createAccount(1, "Vivek","p@ss",20000,12);
		
		a1.show();
		
		
		
	}

}
