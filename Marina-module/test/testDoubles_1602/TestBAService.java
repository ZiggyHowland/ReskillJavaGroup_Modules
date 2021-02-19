package testDoubles_1602;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 //This is a specialised test runner, which automatically initializes all mocks annotated with @Mock prior to each test method
public class TestBAService {

    BankAccount marina;

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

}
