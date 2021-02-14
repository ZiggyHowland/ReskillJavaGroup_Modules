package javaTdd.chap02_IndustrialStrength;

import java.util.HashMap;

public class RoomManager {
    // 1 Room
    private final static int DAYS = 10;
    private final static int SLOTS = 8;
    private Student[][] bookings;
    private int[] timeIndexMapping = {9,10,11,12,13,14,15,16};


    public RoomManager() {
        bookings = new Student[DAYS][SLOTS];
    }


    /**
     * Method gives you an available time of the day you want to book
     * @param student The Student object booking a room
     * @param day int telling which day you want to book your room
     * @throws RuntimeException if no room avilable on the given day
     */
    public boolean bookRoom(Student student, int day) throws RuntimeException {
        int time = getFirstAvailableTimeOnDay(day);
        bookings[day][time] = student;
        student.bookSlot();
        return true;
    }

    /**
     * Method will try to book a room on the given day and time.
     * @param student The Student object booking a room
     * @param day int telling which day you want to book your room
     * @param time int telling which hour from 9 to 16 you want
     * @throws RuntimeException if wanted slot is not available
     */
    public void bookRoom(Student student, int day, int time) {
        int slot = timeIndexMapping[time]; // THIS IS WRONG!
        if (isRoomAvailable(day, time)) {
            bookings[day][time] = student;
            student.bookSlot();
        }
    }


    /**
     *
     * @param day int of which day booking is wanted
     * @return int representing the time slot available
     * @throws RuntimeException if no time slot found
     */

    private int getFirstAvailableTimeOnDay(int day) {
        for (int j = 0; j < SLOTS; j++) {
            if (bookings[day][j] == null) {
                return j;
            }
        }
        throw new RuntimeException("No timeslot available on the given day");
    }


    private boolean isRoomAvailable(int day, int time) {
        return bookings[day][time] == null;
    }

}
