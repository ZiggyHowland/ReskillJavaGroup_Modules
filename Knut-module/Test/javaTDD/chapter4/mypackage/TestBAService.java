package javaTDD.chapter4.mypackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class TestBAService {

    @Mock
    BARestClient baRestClient;

    @Mock
    UI ui;

    @InjectMocks
    BAService fixture;

    BankAccount account1;



    @Before
    public void setup(){
        account1 = new BankAccount("Agent");
        account1.setId(47);
        account1.deposit(100);

    }

    @Test
    public void depositIntoAccount_existingAccount_IncreaseBalance(){

        System.out.println(account1.getBalance());

        when(ui.promptForInteger("Account id")).thenReturn(47);
        when(baRestClient.getById(47)).thenReturn(account1);
        when(ui.promptForInteger("Amount to deposit")).thenReturn(100);
        when(baRestClient.update(47, account1)).thenReturn(true);

        fixture.depositIntoAccount();

        Assert.assertEquals(200, account1.getBalance());
        System.out.println(account1.getBalance());
        }


    @Test
    public void withdrawFromAccount_existingAccount_DecreaseBalance(){

        when(ui.promptForInteger("Account id")).thenReturn(47);
        when(baRestClient.getById(47)).thenReturn(account1);
        when(ui.promptForInteger("Amount to withdraw")).thenReturn(50);
        when(baRestClient.update(47, account1)).thenReturn(true);

        fixture.withdrawFromAccount();

        Assert.assertEquals(50, account1.getBalance());
        System.out.println(account1.getBalance());
    }

//    @Test






}
