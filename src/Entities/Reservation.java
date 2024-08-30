package Entities;

public class Reservation {
    public String GuestName;
    public Room Room;
    public String CheckInDate;
    public String CheckOutDate;
    public Reservation(String guestName, Room room, String checkInDate, String checkOutDate) {
        GuestName = guestName;
        Room = room;
        CheckInDate = checkInDate;
        CheckOutDate = checkOutDate;
    }

}
