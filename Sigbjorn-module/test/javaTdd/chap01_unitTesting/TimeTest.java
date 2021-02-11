package javaTdd.chap01_unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



class TimeTest {

    @Test
    void creatingTime_withNoInput_shouldRepresentMidnight() {
        // Arrange + Act
        Time t = new Time();
        // Assert:
        Assertions.assertEquals("00:00:00", t.toString());
    }

    @Test
    void creatingTime_withValidMinutesOnly_shouldRepresentATimeBetweenMidnightAndOne(){
        Time t = new Time(0,52,12);
        Assertions.assertEquals("00:52:12", t.toString());
    }

    @Test
    void creatingTime_withValidHourMinuteSecond_shouldRepresentATime() {
        Time t = new Time(6,12,59);
        Assertions.assertEquals("06:12:59", t.toString());
    }

    @Test
    void addingTime_twoHoursFromMidnight_shouldReturnTwoOClock() {
        Time t = new Time();
        t.add(2,0,0);
        Assertions.assertEquals("02:00:00", t.toString());
    }

    @Test
    void addingAndCreating_twoDifferentApproaches_shouldReturnEqualObjects() {
        Time t1 = new Time();
        t1.add(3,45, 59);
        Time t2 = new Time(3,45,59);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void timeEqualsFunction_twoSimilarObjects_shouldReturnTrue() {
        Time t1 = new Time();
        t1.add(3,45, 59);
        Time t2 = new Time(3,45,59);
        Assertions.assertTrue(t1.equals(t2));
    }

    @Test
    void timeEqualsFunction_withNoTimeParameter_shouldReturnFalse() {
        Time t = new Time();
        String s = "Olsen";
        Assertions.assertFalse(t.equals(s));
    }


    @Test
    void subtracting_withEqualObject_shouldSetTimeToMidnight() {
        Time t1 = new Time(22,32,52);
        Time t2 = new Time();
        t2.add(22,32,52);
        t1.subtract(t2); // Not good since testing two different things
        Assertions.assertEquals("00:00:00", t1.toString());
    }

    @Test
    void subtracting_whenSubtrahendIsHigherThanMinuend_shouldReturnException() {
        Time t1 = new Time(3,4,5);
        Time t2 = new Time( 23,22, 21);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t1.subtract(t2);
        });
    }

    @Test
    void subtracting_whenSubtrahendIsLowerThanMinuend_shouldReturnNewTime() {
        Time t1 = new Time(5,4,3);
        Time t2 = new Time(4,3,2);
        t1.subtract(t2);
        Assertions.assertEquals("01:01:01", t1.toString());
    }


    @Test()
    @Disabled
    void creating_withValuesOutOfRange_shouldReturnException() {
        Time t1 = new Time(25, 63, 91);
    }




}