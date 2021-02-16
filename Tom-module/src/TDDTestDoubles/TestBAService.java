package dnb.reskill.tom.TDDTestDoubles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestBAService {

    @Mock
    private BARestClient restClient;
    @Mock
    private UI testUI;

    @InjectMocks
    BAService testBAService;

    BankAccount ba101;

    @Before
    public void setup() {
        ba101 = new BankAccount("Tom");
        ba101.setId(101);
        ba101.deposit(5000);
    }

    @Test
    public void depositIntoAccount_existingAccount_increasesBalance(){
        when(testUI.promptForInteger("Account id")).thenReturn(101);
        when(restClient.getById(101)).thenReturn(ba101);
        when(testUI.promptForInteger("Amount to deposit")).thenReturn(1000);
        when(restClient.update(101,ba101)).thenReturn(true);

        // Act.
        testBAService.depositIntoAccount();


        // Assert.
        assertThat(ba101.getBalance(), equalTo(6000));

        // Verify expected methods were invoked on the mock objects.
        verify(restClient).getById(101);
        verify(testUI, times(2)).promptForInteger(anyString());
        verify(restClient).update(101, ba101);
    }

    /*Now switch back to the TestBAService class and write a test method named something like
    depositIntoAccount_existingAccount_increasesBalance(). Implement the test as follows:
•	Set expectations on the BARestClient and UI mock objects, i.e.
tell Mockito what methods you expect to be invoked on these mock objects, and what values Mockito should return in each case.
•	"Act", i.e. call depositIntoAccount() on the BAService fixture object.
•	"Assert", i.e. verify the bank account's balance has been increased due to the deposit.
•	Verify the expected methods were invoked on the BARestClient and UI mock objects. This ensures the test fixture object interacted with the mock objects in the prescribed manner.
*/

}
