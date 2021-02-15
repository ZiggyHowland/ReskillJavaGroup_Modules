package javaTdd.chap04_TestDoubles.mypackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.class) // Used alternative setup in @Before-part
public class BAServiceTest {
    @Mock
    private BARestClient baRestClient;
    @Mock
    private UI ui;
    @InjectMocks
    private BAService baService; // Mockito will automatically create an instance of this class, and pass mock objects into its constructor as necessary.

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositIntoAccount_existingAccount_increaseBalance() {
        // Arrange
        BankAccount ba = new BankAccount("Salaries");
        when(ui.promptForInteger("Account id")).thenReturn(1);
        when(baRestClient.getById(1)).thenReturn(ba);
        when(ui.promptForInteger("Amount to deposit")).thenReturn(340);

        // Act
        baService.depositIntoAccount();

        // Assert
        Assert.assertEquals(340, ba.getBalance());

        // Verify mocks
        verify(ui).promptForInteger("Account id");
        verify(baRestClient).getById(1);
        verify(ui).promptForInteger("Amount to deposit");
        verify(baRestClient).update(1, ba); // Making sure the verify method got called (!!!)
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositIntoAccount_nonExistingAccount_exceptionOccurs() {
        // Arrange
        when(ui.promptForInteger("Account id")).thenReturn(11);
        when(baRestClient.getById(11)).thenReturn(null);

        // Act
        baService.depositIntoAccount();

        // No assert needed - expects Exception

        // Verify mocks
        verify(ui).promptForInteger("Account id");
        verify(baRestClient).getById(11);
        // No more mocked functions should have been called.
    }

    @Test
    public void withdrawFromAccount_existingAccount_decreaseBalance() {
        // Arrange
        BankAccount ba = new BankAccount("Salaries");
        ba.deposit(500);
        when(ui.promptForInteger("Account id")).thenReturn(1);
        when(baRestClient.getById(1)).thenReturn(ba);
        when(ui.promptForInteger("Amount to withdraw")).thenReturn(300);

        // Act
        baService.withdrawFromAccount();

        // Assert
        assertEquals(200, ba.getBalance());

        // Verify mocks
        verify(ui).promptForInteger("Account id");
        verify(ui).promptForInteger("Amount to withdraw");
        verify(baRestClient).getById(1);
        verify(baRestClient).update(1, ba);

    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void withdrawFromAccount_nonExistingAccount_ExceptionOccurs() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Invalid account id");
        when(ui.promptForInteger("Account id")).thenReturn(11);
        when(baRestClient.getById(11)).thenReturn(null);

        // Act
        baService.withdrawFromAccount();

        // Assert (not needed since exception expected

        // Verify
        verify(ui).promptForInteger("Account ids"); //BUG
        verify(baRestClient).getById(11);
        verify(ui, never()).promptForInteger("Amount to withdraw");
        verify(baRestClient, atLeastOnce()).update(11, null); // BUG
    }

    @Test
    public void transferFunds_existingAccounts_amountTransferred() {
        // Arrange
        BankAccount ba1 = new BankAccount("From");
        ba1.deposit(400);
        BankAccount ba2 = new BankAccount("To");
        ba2.deposit(400);
        when(ui.promptForInteger("Account id #1")).thenReturn(11);
        when(ui.promptForInteger("Account id #2")).thenReturn(12);
        when(baRestClient.getById(11)).thenReturn(ba1);
        when(baRestClient.getById(12)).thenReturn(ba2);
        when(ui.promptForInteger("Amount to transfer")).thenReturn(200);

        // Act
        baService.transferFunds();

        // Assert
        assertTrue(ba1.getBalance() == 200 && ba2.getBalance() == 600);

        // Verify mocks
        verify(ui).promptForInteger("Account id #1");
        verify(ui).promptForInteger("Account id #2");
        verify(baRestClient).getById(11);
        verify(baRestClient).getById(12);
        verify(ui).promptForInteger("Amount to transfer");
        verify(baRestClient).update(11, ba1);
        verify(baRestClient).update(12, ba2);
        //verify(baRestClient, never()).update(12, ba2);
    }



}