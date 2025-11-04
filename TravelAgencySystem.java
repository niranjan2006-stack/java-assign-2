package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TravelAgencySystem {
    private static Scanner sc = new Scanner(System.in);
    private static List<TourPackage> packages = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Travel Agency Menu ---");
            System.out.println("1. Add Tour Package");
            System.out.println("2. Add Itinerary Item");
            System.out.println("3. Add Customer");
            System.out.println("4. Create Booking");
            System.out.println("5. Record Payment");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Display Packages & Availability");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            while (!sc.hasNextInt()) { sc.next(); System.out.print("Enter a number: "); }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addTourPackage();
                case 2 -> addItineraryItem();
                case 3 -> addCustomer();
                case 4 -> createBooking();
                case 5 -> recordPayment();
                case 6 -> cancelBooking();
                case 7 -> displayPackages();
                case 8 -> System.out.println("Bye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }

    private static void addTourPackage() {
        System.out.print("Enter Package ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Seats Available: ");
        int seats = sc.nextInt();
        packages.add(new TourPackage(id, name, price, seats));
        System.out.println("Package Added!");
    }

    private static void addItineraryItem() {
        System.out.print("Enter Package ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (TourPackage tp : packages) {
            if (tp.getId() == id) {
                System.out.print("Enter Day: ");
                String day = sc.nextLine();
                System.out.print("Enter Description: ");
                String desc = sc.nextLine();
                tp.addItineraryItem(new ItineraryItem(day, desc));
                System.out.println("Itinerary Added!");
                return;
            }
        }
        System.out.println("Package not found!");
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        customers.add(new Traveler(id, name, age));
        System.out.println("Customer Added!");
    }

    private static void createBooking() {
        System.out.print("Enter Booking ID: ");
        int bid = sc.nextInt();
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        System.out.print("Enter Package ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Seats to Book: ");
        int seats = sc.nextInt();

        Customer customer = customers.stream().filter(c -> c.getId() == cid).findFirst().orElse(null);
        TourPackage tp = packages.stream().filter(p -> p.getId() == pid).findFirst().orElse(null);

        if (tp != null && customer != null && tp.getSeatsAvailable() >= seats) {
            Booking booking = new Booking(bid, customer, tp, seats);
            booking.confirmBooking();
            bookings.add(booking);
            System.out.println("Booking Confirmed!");
        } else {
            System.out.println("Booking Failed!");
        }
    }

    private static void recordPayment() {
        System.out.print("Enter Booking ID: ");
        int bid = sc.nextInt();
        Booking booking = bookings.stream().filter(b -> b.getBookingId() == bid).findFirst().orElse(null);
        if (booking != null) {
            System.out.print("Enter Payment ID: ");
            int pid = sc.nextInt();
            Payment payment = new Payment(pid, booking.getTourPackage().getPrice());
            payment.completePayment();
            booking.setPayment(payment);
            payment.displayReceipt();
        } else {
            System.out.println("Booking not found!");
        }
    }

    private static void cancelBooking() {
        System.out.print("Enter Booking ID: ");
        int bid = sc.nextInt();
        Booking booking = bookings.stream().filter(b -> b.getBookingId() == bid).findFirst().orElse(null);
        if (booking != null) {
            booking.cancelBooking();
            Cancellation cancel = new Cancellation(new Random().nextInt(1000), booking);
            cancel.displayCancellationSummary();
            bookings.remove(booking);
        } else {
            System.out.println("Booking not found!");
        }
    }

    private static void displayPackages() {
        for (TourPackage tp : packages) tp.display();
    }
}