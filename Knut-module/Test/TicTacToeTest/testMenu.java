package TicTacToeTest;

import TicTacToe.Dependencies.UiFromConsole;
import TicTacToe.Gameboard;
import TicTacToe.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// ANDY: Class names (and therefore .java files) should always start with a capital letter.
@RunWith(MockitoJUnitRunner.class)
public class testMenu {
Gameboard gameboard;

    @Mock
    UiFromConsole mockUiFromConsole;

    @InjectMocks
    Menu fixture;

    @Before
    public void setup(){

    }

    @Test
    public void inputFromUser_validSelection(){


        when(mockUiFromConsole.inputFromUser()).thenReturn("c2");

        String actual = fixture.getInputFromUser();
        Assert.assertEquals("c2", actual);

        verify(mockUiFromConsole, times(1)).inputFromUser();

    }
    @Test
    public void turnCountEvenSetsPlayer1(){

        fixture.setPlayer1or2_followTurnCount(6);

        // ANDY: I think it would be ok to keep these as 2 separate calls:
        // String actualPlayer = fixture.getPlayer();
        // String actualSymbol = fixture.getPlayerSymbol();
        
        String expected = "Player 1X";
        String actual = (fixture.getPlayer()+fixture.getPlayerSymbol());

        // ANDY: Then you could have 2 asserts. I think this is ok here.
        // Assert.assertEquals("Player 1", actualPlayer);
        // Assert.assertEquals("X", actualSymbol);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void turnCountEvenSetsPlayer2(){

        fixture.setPlayer1or2_followTurnCount(7);

        // ANDY: See my comments in turnCountEvenSetsPlayer1() about how you could make this code simpler.
        String expected = "Player 2O";
        String actual = (fixture.getPlayer()+fixture.getPlayerSymbol());

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void gameboardIsUpdatedAfterSingleInput(){

       String actual = fixture.validInput_updateGameboard("c2");
       String expected = String.format("\n  A B C \n1 _ _ _ \n2 _ _ X \n3 _ _ _ \n");

       Assert.assertEquals(expected, actual);
    }
    @Test
    public void fullGameVictoryPlayer1(){

        // ANDY: You can use a more fluid style for cascading function calls:
        /*
        when(mockUiFromConsole.inputFromUser())
            .thenReturn("c3")
            .thenReturn("a1")
            .thenReturn("b2")
            .thenReturn("c1")
            .thenReturn("B1")
            .thenReturn("a3")
            .thenReturn("a2")
            .thenReturn("c2")
            .thenReturn("b3");
        */
        
        when(mockUiFromConsole.inputFromUser()).thenReturn("c3").thenReturn("a1")
        .thenReturn("b2").thenReturn("c1").thenReturn("B1").thenReturn("a3")
        .thenReturn("a2").thenReturn("c2").thenReturn("b3");

        fixture.mainMenu();

        String expected = "Victory";
        String actual = fixture.updateBoard;

        Assert.assertEquals(expected, actual);
        verify(mockUiFromConsole, times(9)).inputFromUser();
    }
    @Test
    public void fullGameVictoryPlayer2(){

        when(mockUiFromConsole.inputFromUser()).thenReturn("c3").thenReturn("a1")
        .thenReturn("b3").thenReturn("c1").thenReturn("b2").thenReturn("b1");

        // ANDY: The mainMenu() function should be renamed to be a verb.
        fixture.mainMenu();

        String expected = "Victory";
        
        // ANDY: You should never have public data.
        String actual = fixture.updateBoard;

        Assert.assertEquals(expected, actual);
        verify(mockUiFromConsole, times(6)).inputFromUser();
    }
    @Test
    public void fullGameDraw(){

        when(mockUiFromConsole.inputFromUser()).thenReturn("c3").thenReturn("a1")
        .thenReturn("b2").thenReturn("c1").thenReturn("c2").thenReturn("a2")
        .thenReturn("c2").thenReturn("a3").thenReturn("b3").thenReturn("b2")
        .thenReturn("b1");

        fixture.mainMenu();

        String expected = "Draw";
        String actual = fixture.updateBoard;

        Assert.assertEquals(expected, actual);

        verify(mockUiFromConsole, times(11)).inputFromUser();
    }
    @Test
    public void fullGame_SameInputNoOverwrite_endsInDraw(){

        when(mockUiFromConsole.inputFromUser()).thenReturn("c3").thenReturn("a1")
                .thenReturn("a1").thenReturn("c3").thenReturn("b2").thenReturn("c1")
                .thenReturn("c2").thenReturn("a2").thenReturn("c2").thenReturn("a3")
                .thenReturn("b3").thenReturn("b2").thenReturn("c2").thenReturn("b1");

        fixture.mainMenu();

        String expected = "Draw";
        String actual = fixture.updateBoard;

        Assert.assertEquals(expected, actual);

        verify(mockUiFromConsole, times(14)).inputFromUser();
    }





   // @Test   - check in gameboard test
   // public void userInputIsInvalid(){


}
