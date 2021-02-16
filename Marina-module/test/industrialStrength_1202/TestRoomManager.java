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
        fixture = new RoomManager();
        registry = new Registry();
        marina = registry.registerStudent("Marina");
        ole = registry.registerStudent("Ole");
        ana = registry.registerStudent("Ana");
        andy = registry.registerStudent("Andy");
    }

    @Test //should return first slot on first day
    public void bookAnySlot_noLimitAndAvailable_canBookSlot() {
        fixture.bookAnySlot(ana, 1);
        Student expected = fixture.getRoomBookings(1,0);
        assertThat(expected, sameInstance(ana));
    }

    @Test
    public void bookAnySlot_reachedSlotLimit_throwException() {
        fixture.bookAnySlot(marina, 1);
        fixture.bookAnySlot(marina, 2);
        fixture.bookAnySlot(marina, 3);
        fixture.bookAnySlot(marina, 4);
        fixture.bookAnySlot(marina, 5);
        fixture.bookAnySlot(marina, 6);
        assertThat(fixture.bookAnySlot(marina, 7), not(true));

    }

    @Test (expected = RuntimeException.class)
    public void bookAnySlot_notAvailableTimeThatDay_throwException () {
        fixture.bookAnySlot(marina, 1);
        fixture.bookAnySlot(ana, 1);
        fixture.bookAnySlot(ole, 1);
        fixture.bookAnySlot(andy, 1);
        fixture.bookAnySlot(marina, 1);
        fixture.bookAnySlot(ana, 1);
        fixture.bookAnySlot(ole, 1);
        fixture.bookAnySlot(andy, 1);
        fixture.bookAnySlot(marina, 1);
    }

    @Test
    public void bookSpecificSlotAndDay_noLimitAndAvailable_canBookSlot() {
        fixture.bookSpecificSlotAndDay(andy, 3,0);
        Student expected = fixture.getRoomBookings(3,0);
        assertThat(expected, sameInstance(andy));
    }

    @Test //Marina can't book because And have already booked the room
    public void bookSpecificSlotAndDay_reachedLimitOrNotAvailable_cannotBookSlot() {
        fixture.bookSpecificSlotAndDay(andy, 3,0);
        fixture.bookSpecificSlotAndDay(marina, 3,0);
        Student expected = fixture.getRoomBookings(3,0);
        assertThat(expected, sameInstance(andy));
    }

    @Test
    public void toString_printsIdNameSlotsAvailable() {
        fixture.bookSpecificSlotAndDay(marina, 1, 1);
        Assert.assertThat(fixture.toString(), containsString("The 2. day from now, these rooms are booked:\n-Time slot 10\n"));
    }





}
