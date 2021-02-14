package javaTdd.chap02_IndustrialStrength;

import lombok.ToString;

@ToString
public class Student {
    private String id;
    private String name;
    private int availableRoomSlots;

    private static final int MINIMUM_SLOT_AVAILABILITY = 1;
    private static final int DEFAULT_SLOT_AVAILABILITY = 6;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.availableRoomSlots = DEFAULT_SLOT_AVAILABILITY;
    }

    public boolean bookSlot() {
        if (this.availableRoomSlots >= MINIMUM_SLOT_AVAILABILITY) {
            this.availableRoomSlots--;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean releaseSlot() {
        if (this.availableRoomSlots < DEFAULT_SLOT_AVAILABILITY) {
            this.availableRoomSlots++;
            return true;
        }
        else {
            return false;
        }
    }

    public int getAvailableRoomSlots() {
        return availableRoomSlots;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

