package industrialStrength_1202;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RunWith(Suite.class) //to tell the compiler that these test must be run in a different way
@Suite.SuiteClasses({TestRegistry.class, TestStudent.class}) //here are the tests that should be run
public class TestSuite {

    //to measure the the total time it takes to execute all the tests
    static LocalDateTime startTime;
    static LocalDateTime endTime;

    //executed once only, at the start/end of the whole test class

    @BeforeClass
    public static void setup() {
        startTime = LocalDateTime.now();
    }

    @AfterClass
    public static void teardown() {
        endTime = LocalDateTime.now();
        long milliseconds = ChronoUnit.MILLIS.between(startTime,endTime);
        System.out.printf("Total duration of tests in milliseconds: %s", milliseconds);
    }




}
