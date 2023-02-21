package fourachievers.lf.practise;

public class ATMExceptionDemoTest {

	public static void main(String[] args) {
		checkPin();
		withdrawMoney();
	}

	private static void checkPin() {
		throw new RuntimeException("Wrong Pin Entered...");
	}

	private static void withdrawMoney() {
		if(checkSufficientMoneyInATM() && checkDenominationAvailable() && checkBalanceAvailableInAccount())
			System.out.println("Cash Dispensed");
		else
			throw new RuntimeException("Denomination of 100 is not available");
	}

	private static boolean checkBalanceAvailableInAccount() {
		return true;
		
	}

	private static boolean checkDenominationAvailable() {
		return false;
		
	}

	private static boolean checkSufficientMoneyInATM() {
		return true;
		
	}
	
	

}
