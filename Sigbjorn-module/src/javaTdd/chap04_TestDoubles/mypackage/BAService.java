package javaTdd.chap04_TestDoubles.mypackage;

public class BAService {

    private BARestClient restClient;
    private UI ui;

    public BAService(BARestClient restClient, UI ui) {
        this.restClient = restClient;
        this.ui = ui;
    }

    public void depositIntoAccount() {
        
    	int id = ui.promptForInteger("Account id");

    	BankAccount acc = restClient.getById(id);
        if (acc == null) {
        	throw new IllegalArgumentException("Invalid account id");
        }
        
    	int amount = ui.promptForInteger("Amount to deposit");
        acc.deposit(amount);
        restClient.update(id, acc);
    }

    public void withdrawFromAccount() {
    	int id = ui.promptForInteger("Account id");

    	BankAccount acc = restClient.getById(id);
        if (acc == null) {
        	throw new IllegalArgumentException("Invalid account id");
        }
        
    	int amount = ui.promptForInteger("Amount to withdraw");
        acc.withdraw(amount);
        restClient.update(id, acc);
    }


    public void transferFunds() {
    	int id1 = ui.promptForInteger("Account id #1");
    	int id2 = ui.promptForInteger("Account id #2");

    	BankAccount acc1 = restClient.getById(id1);
    	BankAccount acc2 = restClient.getById(id2);
        if (acc1 == null || acc2 == null) {
        	throw new IllegalArgumentException("Invalid account id(s)");
        }
        
    	int amount = ui.promptForInteger("Amount to transfer");
        acc1.withdraw(amount);
        acc2.deposit(amount);
        restClient.update(id1, acc1);
        restClient.update(id2, acc2);
    }
}
