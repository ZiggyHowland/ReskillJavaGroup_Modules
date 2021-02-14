package javaTdd.chap02_industrialStrength;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.time.Instant;

@RunWith(Suite.class)
@SuiteClasses({TestRegistry.class, TestStudent.class})
public class TestSuiteA {
    @BeforeClass
    public static void beforeSuite() {
        System.out.println("Before suite: " + Instant.now());
    }

    @AfterClass
    public static void afterSuite() {
        System.out.println("After suite: " + Instant.now());
    }

}
