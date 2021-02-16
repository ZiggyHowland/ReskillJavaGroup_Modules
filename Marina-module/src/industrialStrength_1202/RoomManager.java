package industrialStrength_1202;

public class RoomManager {

    //manages bookings for a single room
    //row = 10 days, column = 8 slots

    private final static int DAYS = 10;
    private final static int TIME_SLOTS = 8;
    private Student[][] roomBookings = new Student[DAYS][TIME_SLOTS];
    private static int[] timeIndexMapping = {9, 10, 11, 12, 13, 14, 15, 16};

    // ANDY: I might rename as bookSlot(). Also see line 37 below...
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

    // ANDY: I might rename as bookSlot() also. So we have 2 overloaded methods named bookSlot().
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
            // ANDY: I would unindent the next statement (minor point!)
                sb.append(String.format("The %d. day from now, these rooms are booked:\n", r+1));
            for (int c = 0; c < TIME_SLOTS; c++) {
                if (!(isRoomAvailableAtGivenTime(r, c))) {
                    // ANDY: I dont understand the return statement here - this will exit the method immediately. I don't think that's what you want to do...?
                    return sb.append(String.format("-Time slot %d\n", timeIndexMapping[c])).toString();             //How could I print the name of the student too?
                    // ANDY: to get the name of the student, cany you do this: 
                    // Student student = roomBookings[r][c];
                    // String studentName = student.getName();  // Or similar...
                }
            }
        }
        return "No bookings so far for this room.\n";
    }
}
