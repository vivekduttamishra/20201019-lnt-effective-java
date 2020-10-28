package in.conceptarchitect.banking;

public class OverDraftAccount extends BankAccount{

	double odLimit;
	public OverDraftAccount(String name, String password, double amount) {
		super(name, password, amount);
		adjustOdLimit();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		if(super.deposit(amount)) {
			adjustOdLimit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void creditInterest(double interestRate) {
		// TODO Auto-generated method stub
		super.creditInterest(interestRate);
		adjustOdLimit();
	}


	private void adjustOdLimit() {
		odLimit=getBalance()*0.1;
	}

	public double getOdLimit() {
		// TODO Auto-generated method stub
		return odLimit;
	}

}
