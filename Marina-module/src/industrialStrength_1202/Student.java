package industrialStrength_1202;


public class Student {

    private Integer Id;
    private String Name;
    private Integer roomSlotsAvailable = 6;

    public Student(Integer id, String name) {
        this.Id = id;
        this.Name = name;
    }

   public String getName() {
        return Name;
    }

    public Integer getRoomSlotsAvailable() {
        return roomSlotsAvailable;
    }

    public Integer getId() {
        return Id;
    }

    public boolean bookSlot() {
        if (roomSlotsAvailable > 0) {
            roomSlotsAvailable--;
            return true;
        } else {
            return false;
        }
    }

    public boolean releaseSlot() {
        if (roomSlotsAvailable < 6) {
            roomSlotsAvailable++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("{%d} %s has %d slot(s) remaining.\n", Id, Name, roomSlotsAvailable);
    }
}

