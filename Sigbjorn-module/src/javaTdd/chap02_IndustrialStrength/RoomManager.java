package javaTdd.chap02_IndustrialStrength;

import java.util.HashMap;

public class RoomManager {
    // 1 Room only
    private final static int DAYS = 10;
    private final static int SLOTS = 8;
    private Student[][] bookings;
    private static int[] timeIndexMapping = {9,10,11,12,13,14,15,16};


    public RoomManager() {
        bookings = new Student[DAYS][SLOTS];
    }


    public boolean hasNoBookings() {
        for (int i = 0; i < DAYS; i++) {
            for (int j = 0; j <SLOTS; j++) {
                if (bookings[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Method gives you an available time of the day you want to book
     * @param student The Student object booking a room
     * @param day int telling which day you want to book your room
     */
    public boolean bookRoom(Student student, int day) {
        int time = getFirstAvailableTimeOnDay(day);
        return updateBooking(student, day, time);
    }

    /**
     * Method will try to book a room on the given day and time.
     * @param student The Student object booking a room
     * @param day int telling which day you want to book your room
     * @param time int telling which hour from 9 to 16 you want
     * @return boolean whether room was booked or not
     */
    public boolean bookRoom(Student student, int day, int time) throws RuntimeException {
        if (isStudentAllowedToBook(student)) {
            int slot = getIndexFromTime(time);
            if (isRoomAvailable(day, time)) {
                return updateBooking(student, day, time);
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    private boolean updateBooking(Student student, int day, int time) {
        bookings[day][time] = student;
        student.bookSlot();
        return true;
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

    private boolean isStudentAllowedToBook(Student student) {
        return student.getAvailableRoomSlots() < Student.getMaximumSlotAvailability();
    }

    /**
     *
     * @param time int representing user oriented time slot (9, 10, 11 etc...)
     * @return int with the array index for the specified time or -1 if not found
     */
    private static int getIndexFromTime(int time) {

        for (int i = 0; i < SLOTS; i++) {
            if (time == timeIndexMapping[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getTimeFromIndex(int index) {
        return timeIndexMapping[index];
    }


}
