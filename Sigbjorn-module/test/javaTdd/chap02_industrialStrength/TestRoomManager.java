package javaTdd.chap02_industrialStrength;

import javaTdd.chap02_IndustrialStrength.Registry;
import javaTdd.chap02_IndustrialStrength.RoomManager;
import javaTdd.chap02_IndustrialStrength.Student;
import org.hamcrest.Matchers;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class TestRoomManager {
    RoomManager rm;
    Registry r;

    @Before
    public void setupTestRoomManager() {
        r = new Registry();
        rm = new RoomManager();
    }

    @Test
    public void newRoomManager_withNoBookings_shouldContainEmptyBookingsArray() {
        assertThat(rm.hasNoBookings(), Matchers.is(true));
    }

    @Test
    @Ignore
    public void firstRoomBooking_withNoTimeSpecified_shouldReturnFirstSlot() {
        Student s = r.registerStudent("Sigbjørn");
        rm.bookRoom(s, 0);


    }

}