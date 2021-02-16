package javaTDD.chapter4.mypackage;

import org.junit.Assert;
import org.junit.Test;

public class TestTester {

    @Test
    public void testBA(){
        String name = "navnet";
        BankAccount ba = new BankAccount(name);
        Assert.assertEquals(name,ba.getName());

    }






}
