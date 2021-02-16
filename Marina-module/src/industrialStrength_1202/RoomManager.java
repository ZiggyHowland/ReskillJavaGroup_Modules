package industrialStrength_1202;

public class RoomManager {

    //manages bookings for a single room
    //row = 10 days, column = 8 slots

    private final static int DAYS = 10;
    private final static int TIME_SLOTS = 8;
    private Student[][] roomBookings = new Student[DAYS][TIME_SLOTS];
    private static int[] timeIndexMapping = {9, 10, 11, 12, 13, 14, 15, 16};


    public boolean bookAnySlot(Student student, int day) {
        if (student.bookSlot()) {
            int firstAvailableTime = getFirstAvailableTimeOnDay(day);
            roomBookings[day][firstAvailableTime] = student;
            return true;
        }
        return false;
    }

    private int getFirstAvailableTimeOnDay(int day) {
        for (int c = 0; c < TIME_SLOTS; c++) {
            if (isRoomAvailableAtGivenTime(day, c)) {
                return c;
            }
        }
        throw new RuntimeException("No timeslot available on given day.\n");
    }

    private boolean isRoomAvailableAtGivenTime(int day, int time) {
        return roomBookings[day][time] == null;
    }


    public void bookSpecificSlotAndDay(Student student, int day, int time) {
        if (student.bookSlot() && isRoomAvailableAtGivenTime(day, time)) {
            roomBookings[day][time] = student;
        }
    }

    public Student getRoomBookings(int day, int time) {
        return roomBookings[day][time];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < DAYS; r++) {
                sb.append(String.format("The %d. day from now, these rooms are booked:\n", r+1));
            for (int c = 0; c < TIME_SLOTS; c++) {
                if (!(isRoomAvailableAtGivenTime(r, c))) {
                    return sb.append(String.format("-Time slot %d\n", timeIndexMapping[c])).toString();             //How could I print the name of the student too?
                }
            }
        }
        return "No bookings so far for this room.\n";
    }
}
