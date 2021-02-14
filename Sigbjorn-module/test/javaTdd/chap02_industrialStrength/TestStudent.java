package javaTdd.chap02_industrialStrength;

import javaTdd.chap02_IndustrialStrength.Student;
//import org.junit.Assert; // => Assert.assertEqual
import static org.junit.Assert.*; // => assertEqual
import org.junit.Before;
import org.junit.Test;

public class TestStudent {
    Student student;

    @Before
    public void setup() {
        student = new Student("SH", "Sigbjørn");
    }

    @Test
    public void newStudent_beforeUse_shouldHaveSixAvailableSlots() {
        // **** Q: Should this method name rather refer to DEFAULT instead of Six, and check towards the constant?
        assertEquals(6, student.getAvailableRoomSlots());
    }

    @Test
    public void newStudent_withNoRoomsBooked_shouldBeAllowedToBookRom() {
        assertTrue(student.bookSlot());
    }

    @Test
    public void bookRoomSlot_byOne_shouldReduceAvailableSlotsByOne() {
        student.bookSlot();
        assertEquals(5, student.getAvailableRoomSlots());
    }

    @Test
    public void bookRoomSlots_withMoreThanOne_shouldReduceAvailability() {
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        assertEquals(2, student.getAvailableRoomSlots());
    }

    @Test
    public void bookRoomSlots_withTooManyBookings_shouldReturnFalse() {
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        student.bookSlot();
        assertFalse(student.bookSlot());
    }

    @Test
    public void releaseRoomSlot_withNewStudent_shouldReturnFalse() {
        assertFalse(student.releaseSlot());
    }

    @Test
    public void releaseRoomSlot_afterOneBooking_shouldChangeAvailabilityToSix() {
        student.bookSlot();
        student.releaseSlot();
        assertEquals(6, student.getAvailableRoomSlots());
    }
	
}
