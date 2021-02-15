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

    public void bookSlot() {
        if (roomSlotsAvailable > 0) {
            roomSlotsAvailable--;
        } else {
            System.out.println("Sorry, you have used your 6 slots to book rooms.\n");
        }
    }

    public void releaseSlot() {
        if (roomSlotsAvailable < 6) {
            roomSlotsAvailable++;
        } else {
            System.out.println("You have already canceled all your room bookings.\n");
        }
    }

    @Override
    public String toString() {
        return String.format("{%d} %s has %d slot(s) remaining.\n", Id, Name, roomSlotsAvailable);
    }
}

