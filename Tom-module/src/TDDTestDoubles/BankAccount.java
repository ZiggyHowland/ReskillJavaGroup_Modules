package dnb.reskill.tom.TDDTestDoubles;

public class BankAccount {

	private int id;
    private String name;
    private int balance = 0;
    
    public BankAccount(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int deposit(int amount) {
    	balance += amount;
    	return balance;
	}

	public int withdraw(int amount) {
    	if (amount > balance)
    		throw new IllegalArgumentException("Insufficient funds");
    	balance -= amount;
    	return balance;
	}

    @Override
    public String toString() {
        return String.format("%s, balance %.02f", name, balance);
    }
}
