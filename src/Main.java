//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Entities.*;

import javax.swing.*;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        //create rooms
        rooms.add(new Room(1, true));
        rooms.add(new Room(2, true));
        rooms.add(new Room(3, true));
        rooms.add(new Room(4, true));
        rooms.add(new Room(5, true));
        rooms.add(new Room(6, true));
        rooms.add(new Room(7, true));
        rooms.add(new Room(8, true));
        rooms.add(new Room(9, true));

        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (true) {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1- Make a reservation");
            System.out.println("2- Cancel a reservation");
            System.out.println("3- Show all reservations");
            System.out.println("4- Show all available rooms");
            System.out.println("6- Update a reservation");
            System.out.println("6- Exit");
            System.out.println("Choose an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    listReservations();
                    break;
                case 4:
                    System.out.println("Show all available rooms");
                    break;
                case 5:
                    updateReservation();
                    return;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void makeReservation() {
        //make a reservation
        String guestName;
        Room room = null;
        String checkInDate;
        String checkOutDate;
        System.out.println("Enter guest name: ");
        guestName = new Scanner(System.in).nextLine();
        System.out.println("Enter room number: ");
        int roomNumber = new Scanner(System.in).nextInt();
        if (!checkRoomAvailability(roomNumber)) {
            System.out.println("Room not found");
            makeReservation();
        } else {
            System.out.println("Enter check-in date: ");
            checkInDate = new Scanner(System.in).nextLine();
            System.out.println("Enter check-out date: ");
            checkOutDate = new Scanner(System.in).nextLine();
            Reservation reservation = new Reservation(guestName, room, checkInDate, checkOutDate);
            reservations.add(reservation);
            System.out.println("Reservation created successfully");
        }
    }

    private static void cancelReservation() {
        listReservations();

        System.out.println("enter the ID of the reservation you want to cancel: ");
        int id = new Scanner(System.in).nextInt();
        reservations.remove(id);
        System.out.println("Reservation canceled successfully");

    }

    private static void listReservations() {
        for (Reservation r : reservations) {
            System.out.println("Reservation ID: " + reservations.indexOf(r));
            System.out.println("Guest name: " + r.GuestName);
            System.out.println("Room number: " + r.Room.Number);
            System.out.println("Check-in date: " + r.CheckInDate);
            System.out.println("Check-out date: " + r.CheckOutDate);
            System.out.println("-------------------------------");
        }
    }

    private static void updateReservation() {
        listReservations();

        String guestName;
        Room room = null;
        String checkInDate;
        String checkOutDate;

        System.out.println("enter the ID of the reservation you want to update: ");
        int id = new Scanner(System.in).nextInt();
        if (!checkReservationAvailability(id)) {
            System.out.println("enter a right ID");
        } else {
            System.out.println("Enter guest name: ");
            guestName = new Scanner(System.in).nextLine();
            System.out.println("Enter room number: ");

            int roomNumber = new Scanner(System.in).nextInt();
            for (Room r : rooms) {
                if (r.Number == roomNumber) {
                    room = r;
                    break;
                }
            }
            if (room == null) {
                System.out.println("Room not found");
                return;
            }

            System.out.println("Enter check-in date: ");
            checkInDate = new Scanner(System.in).nextLine();
            System.out.println("Enter check-out date: ");
            checkOutDate = new Scanner(System.in).nextLine();
            Reservation reservation = new Reservation(guestName, room, checkInDate, checkOutDate);
            reservations.set(id, reservation);
        }


    }

    private static boolean checkReservationAvailability(int id) {
        if (id >= 0 && id < reservations.size()) {
            Reservation reservation = reservations.get(id);
            return reservation != null;
        }
        return false;
    }

    private static boolean checkRoomAvailability(int id) {
        if (id >= 0 && id < rooms.size()) {
            Room room = rooms.get(id);
            return room != null;
        } else {
            return false;
        }
    }

}
