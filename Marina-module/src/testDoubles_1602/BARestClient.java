package testDoubles_1602;

import java.util.List;

public interface BARestClient {
    List<BankAccount> getAll();
    BankAccount getById(int id);
    BankAccount insert(BankAccount acc);
    boolean update(int id, BankAccount acc);
    boolean delete(int id);
}
