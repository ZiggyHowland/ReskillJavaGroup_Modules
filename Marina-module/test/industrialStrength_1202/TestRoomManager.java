package industrialStrength_1202;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestRoomManager {

    RoomManager fixture;
    Student marina, ole, ana, andy;
    Registry registry;

    @Before
    public void setup() {
        // ANDY: This is the correct approach - nice.
        fixture = new RoomManager();
        registry = new Registry();
        marina = registry.registerStudent("Marina");
        ole = registry.registerStudent("Ole");
        ana = registry.registerStudent("Ana");
        andy = registry.registerStudent("Andy");
    }

    @Test //should return first slot on first day
    public void bookAnySlot_noLimitAndAvailable_canBookSlot() {
        fixture.bookSlot(ana, 1);
        Student expected = fixture.getRoomBookings(1,0);
        // ANDY: Yes
        assertThat(expected, sameInstance(ana));
    }

    @Test
    public void bookAnySlot_reachedSlotLimit_throwException() {
        fixture.bookSlot(marina, 1);
        fixture.bookSlot(marina, 2);
        fixture.bookSlot(marina, 3);
        fixture.bookSlot(marina, 4);
        fixture.bookSlot(marina, 5);
        fixture.bookSlot(marina, 6);
        // ANDY: Yes
        assertThat(fixture.bookSlot(marina, 7), not(true));

    }

    @Test (expected = RuntimeException.class)
    public void bookAnySlot_notAvailableTimeThatDay_throwException () {
        // ANDY: I don't understand this test. You're booking the same slot every time. Is that deliberate?
        fixture.bookSlot(marina, 1);
        fixture.bookSlot(ana, 1);
        fixture.bookSlot(ole, 1);
        fixture.bookSlot(andy, 1);
        fixture.bookSlot(marina, 1);
        fixture.bookSlot(ana, 1);
        fixture.bookSlot(ole, 1);
        fixture.bookSlot(andy, 1);
        fixture.bookSlot(marina, 1);
    }

    @Test
    public void bookSpecificSlotAndDay_noLimitAndAvailable_canBookSlot() {
        // ANDY: Yes
        fixture.bookSlot(andy, 3,0);
        Student expected = fixture.getRoomBookings(3,0);
        assertThat(expected, sameInstance(andy));
    }

    @Test //Marina can't book because And have already booked the room
    public void bookSpecificSlotAndDay_reachedLimitOrNotAvailable_cannotBookSlot() {
        // ANDY: Yes
        fixture.bookSlot(andy, 3,0);
        fixture.bookSlot(marina, 3,0);
        Student expected = fixture.getRoomBookings(3,0);
        assertThat(expected, sameInstance(andy));
    }

    @Test
    public void toString_printsIdNameSlotsAvailable() {
        fixture.bookSlot(marina, 1, 1);
        // ANDY: I didn't understand the toString() function, so I'm not sure if this test is correct...
        Assert.assertThat(fixture.toString(), containsString("The 2. day from now, these rooms are booked:\n-Time slot 10\n"));
    }





}
