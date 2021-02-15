package industrialStrength_1202;

import org.junit.Before;
import org.junit.Test;

import static industrialStrength_1202.idMatcher.isValidStudentId;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class TestStudent {

    public Student fixture;

    @Before
    public void setUp() {
        fixture = new Student(1, "Marina");
    }

    @Test
    public void student_validStudentId_idAccepted() {
        Student fixture = new Student(9, "Haakon");
        assertThat(fixture.getId(), isValidStudentId());
    }

    @Test
    public void student_negativeStudentId_idRejected() {
        Student fixture = new Student(-1, "Haakon");
        assertThat(fixture.getId(), not(isValidStudentId()));
    }

    @Test
    public void student_tooHighStudentId_idRejected() {
        Student fixture = new Student(6666, "Haakon");
        assertThat(fixture.getId(), not(isValidStudentId()));
    }


    @Test
    public void makeStudent_withIdNameSlots_correctlyInstantiated() {
        assertEquals(fixture.getName(), "Marina");
        assertThat(fixture.getId(), equalTo(1));
        assertThat(fixture.getRoomSlotsAvailable(), equalTo(6));
    }

    @Test
    public void bookSlot_haveRoomSlotsAvailable_canBook() {
        fixture.bookSlot();
        fixture.bookSlot();
        assertThat(fixture.getRoomSlotsAvailable(), equalTo(4));
    }

    @Test
    public void bookSlot_doNotHaveRoomSlotsAvailable_canNotBook() {
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.bookSlot();
        assertThat(fixture.getRoomSlotsAvailable(), equalTo(0));
    }

    @Test
    public void releaseSlot_haveRoomSlotsFull_canNotReleaseMore() {
        fixture.releaseSlot();
        assertThat(fixture.getRoomSlotsAvailable(), equalTo(6));
    }

    @Test
    public void releaseSlot_book2Release1_canReleaseBooking() {
        fixture.bookSlot();
        fixture.bookSlot();
        fixture.releaseSlot();
        assertThat(fixture.getRoomSlotsAvailable(), equalTo(5));
    }

    @Test
    public void toString_printsIdNameSlotsAvailable() {
        assertThat(fixture.toString(), containsString("{1} Marina has 6 slot(s) remaining."));
    }

}