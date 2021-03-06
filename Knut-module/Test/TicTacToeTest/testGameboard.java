package TicTacToeTest;

import TicTacToe.Gameboard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// ANDY: Class name should always start with capital letter.
public class testGameboard {

    Gameboard fixture;

    // ANDY: I deleted some blank lines, to make it "tighter".
    
    @Before
    public void setup(){
        fixture = new Gameboard();
    }

    @Test
    public void inputFromUser_InvalidSelection(){
        boolean expected = false;
        boolean actual = fixture.checkIfInputIsValid("Incorrect input");
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void inputFromUser_InvalidSelection_slotAlreadyTaken(){    
        fixture.editBoard("a2", "O");
        boolean expected = false;
        boolean actual = fixture.checkIfInputIsValid("a2");
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void inputFromUser_valid(){
        boolean expected = true;
        boolean actual = fixture.checkIfInputIsValid("a2");
        Assert.assertEquals(expected, actual);
    }

}
