package testDoubles_1602;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

//This is a specialised test runner, which automatically initializes all mocks annotated with @Mock prior to each test method
public class TestBAService {

    BankAccount marina;
    BankAccount ola;

    @Mock //Declare an instance variable of the dependency interface type
    BARestClient mockBARestClient;

    @Mock
    UI mockUI;

    @InjectMocks //To create a CUT (class-under-test) object and have mocks injected into it
    BAService fixture;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        marina = new BankAccount("Marina");
        marina.deposit(2000);
        ola = new BankAccount("Ola");
        ola.deposit(1000);
    }

    @Test
    public void depositIntoAccount_existingAccount_increaseBalance() {

        //"setting expectations"
        when(mockUI.promptForInteger("Account id")).thenReturn(120);
        when(mockUI.promptForInteger("Amount to deposit")).thenReturn(1000);
        when(mockBARestClient.getById(120)).thenReturn(marina);
        when(mockBARestClient.update(120, marina)).thenReturn(true);

        //Act
        fixture.depositIntoAccount();

        //Assert
        assertThat(marina.getBalance(), equalTo(3000));

        //Verify expected methods were invoked on the mock objects
        verify(mockUI).promptForInteger("Account id");
        verify(mockUI).promptForInteger("Amount to deposit");
        verify(mockBARestClient).getById(120);
        verify(mockBARestClient).update(120, marina);
    }

    @Test (expected=IllegalArgumentException.class)
    public void depositIntoAccount_nonExistingAccount_exceptionOccurs() {
       when(mockBARestClient.getById(666)).thenReturn(null);
       fixture.depositIntoAccount();
    }

    @Test
     public void withdrawFromAccount_existingAccount_decreaseBalance() {

        when(mockUI.promptForInteger("Account id")).thenReturn(121);
        when(mockBARestClient.getById(121)).thenReturn(ola);
        when(mockUI.promptForInteger("Amount to withdraw")).thenReturn(200);
        when(mockBARestClient.update(121, ola)).thenReturn(true);

        //Act
        fixture.withdrawFromAccount();

        //Assert
        assertThat(ola.getBalance(), equalTo(800));

        //Verify expected methods were invoked on the mock objects
        verify(mockUI).promptForInteger("Account id");
        verify(mockUI).promptForInteger("Amount to withdraw");
        verify(mockBARestClient).getById(121);
        verify(mockBARestClient).update(121, ola);
    }

     @Test (expected=IllegalArgumentException.class)
     public void withdrawFromAccount_nonExistingAccount_exceptionOccurs() {
         when(mockBARestClient.getById(666)).thenReturn(null);
         fixture.withdrawFromAccount();
     }

     @Test
     public void transferFunds_existingAccounts_amountTransferred() {
             when(mockUI.promptForInteger("Account id #1")).thenReturn(120);
             when(mockUI.promptForInteger("Account id #2")).thenReturn(121);
             when(mockUI.promptForInteger("Amount to transfer")).thenReturn(500);

             when(mockBARestClient.getById(120)).thenReturn(marina);
             when(mockBARestClient.getById(121)).thenReturn(ola);

             when(mockBARestClient.update(120, marina)).thenReturn(true);
             when(mockBARestClient.update(121, ola)).thenReturn(true);

             fixture.transferFunds();

             assertThat(ola.getBalance(), equalTo(1500));

             verify(mockUI,times(3)).promptForInteger(anyString());
             verify(mockBARestClient, times(2)).getById(anyInt());
             verify(mockBARestClient, times(2)).update(anyInt(), anyObject());

     }




 }
